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
  apache restart           Apacheを再起動します。
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
        rm -Rf ./mysql/data && mkdir ./mysql/data && chmod 777 ./mysql/data
        rm -Rf ./mysql/logs && mkdir ./mysql/logs && chmod 777 ./mysql/logs
        rm -Rf ./apache/logs && mkdir ./apache/logs && chmod 777 ./apache/logs
        rm -Rf ./solr/logs/* && mkdir ./solr/logs && chmod 777 ./solr/logs
        rm -Rf ./solr/data/mycore/data/* && mkdir ./solr/data/mycore/data && chmod 777 ./solr/data/mycore/data
        rm -Rf ./solr/data/post/data/* && mkdir ./solr/data/post/data && chmod 777 ./solr/data/post/data
        rm -Rf ./elasticsearch/data/* && mkdir ./elasticsearch/data && chmod 777 ./elasticsearch/data
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

    apache)
      case ${2} in
          login)
              $DOCKER_COMPOSE exec apache /bin/sh
          ;;
          restart)
              $DOCKER_COMPOSE restart apache
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
              mysqldump --skip-column-statistics -u root -h 127.0.0.1 -A > ${3}
          ;;
          import)
              mysql -u root -h 127.0.0.1 --default-character-set=utf8mb4 < ${3}
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

    aws)
      case ${2} in
          local)
              $DOCKER_COMPOSE exec awscli /bin/bash
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


