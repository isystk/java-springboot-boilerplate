FROM alpine:latest

MAINTAINER isystk

# nginxのインストール
RUN apk update && \
    apk add --no-cache nginx

# タイムゾーンを東京に設定
RUN apk --update --no-cache add tzdata && \
    cp /usr/share/zoneinfo/Asia/Tokyo /etc/localtime && \
    apk del tzdata && \
    rm -rf /var/cache/apk/*

# ポート設定
EXPOSE 80 443

RUN mkdir -p /run/nginx

# フォアグラウンドでnginx実行
CMD nginx -g "daemon off;"
