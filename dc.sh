#! /bin/bash

DOCKER_HOME=./docker
DOCKER_COMPOSE="docker-compose -f $DOCKER_HOME/docker-compose.yml"

function usage {
    cat <<EOF
$(basename ${0}) is a tool for ...

Usage:
  $(basename ${0}) [command] [<options>]

Options:
  stats|st                 Dockerコンテナの状態を表示します。
  init                     Dockerコンテナ・イメージ・生成ファイルの状態を初期化します。
  start                    すべてのDaemonを起動します。
  stop                     すべてのDaemonを停止します。
  nginx restart            Nginxを再起動します。
  mysql login              MySQLデータベースにログインします。
  mysql export <PAHT>      MySQLデータベースのdumpファイルをエクスポートします。
  mysql import <PAHT>      MySQLデータベースにdumpファイルをインポートします。
  mysql restart            MySQLデータベースを再起動します。
  --version, -v     バージョンを表示します。
  --help, -h        ヘルプを表示します。
EOF
}

function version {
    echo "$(basename ${0}) version 0.0.1 "
}

case ${1} in
    stats|st)
        docker container stats
    ;;

    init)
        # 停止＆削除（コンテナ・イメージ・ボリューム）
        pushd $DOCKER_HOME
        docker-compose down --rmi all --volumes
        rm -Rf ./mysql/logs && mkdir ./mysql/logs && chmod 777 ./mysql/logs
#        rm -Rf ./apache/logs && mkdir ./apache/logs && chmod 777 ./apache/logs
        rm -Rf ./nginx/logs && mkdir ./nginx/logs && chmod 777 ./nginx/logs
        rm -Rf ./solr/logs/* && mkdir ./solr/logs && chmod 777 ./solr/logs
        rm -Rf ./solr/data/mycore/data/* && mkdir ./solr/data/mycore/data && chmod 777 ./solr/data/mycore/data
        rm -Rf ./solr/data/stock/data/* && mkdir ./solr/data/stock/data && chmod 777 ./solr/data/stock/data
        rm -Rf ./s3/data && mkdir ./s3/data && chmod 777 ./s3/data
        popd
        chmod 777 ./htdocs
    ;;

    start)
        $DOCKER_COMPOSE up -d
    ;;
    
    stop)
        pushd $DOCKER_HOME
        docker-compose down
        popd
    ;;

    nginx)
      case ${2} in
          login)
              $DOCKER_COMPOSE exec nginx /bin/sh
          ;;
          restart)
              $DOCKER_COMPOSE restart nginx
          ;;
          *)
              usage
          ;;
      esac
    ;;

    mysql)
      case ${2} in
          login)
              mysql -u user -ppassword -h 127.0.0.1 laraec
          ;;
          export)
              mysqldump --skip-column-statistics -u root -ppassword -h 127.0.0.1 -A > ${3}
          ;;
          import)
              mysql -u root -ppassword -h 127.0.0.1 --default-character-set=utf8mb4 < ${3}
              $DOCKER_COMPOSE restart mysql
          ;;
          restart)
              $DOCKER_COMPOSE restart mysql
          ;;
          *)
              usage
          ;;
      esac
    ;;

    front)
      case ${2} in
          build)
              pushd web-front/resources
              yarn fix
              yarn build
              popd
          ;;
          *)
              usage
          ;;
      esac
    ;;

    help|--help|-h)
        usage
    ;;

    version|--version|-v)
        version
    ;;
    
    *)
        echo "[ERROR] Invalid subcommand '${1}'"
        usage
        exit 1
    ;;
esac


