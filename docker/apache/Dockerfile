FROM httpd:2.4
RUN sed -i \
        -e 's/^#\(Include .*httpd-dav.conf\)/\1/' \
        -e 's/^#\(LoadModule .*mod_auth_digest.so\)/\1/' \
        -e 's/^#\(LoadModule .*mod_rewrite.so\)/\1/' \
        -e 's/^#\(LoadModule .*mod_ssl.so\)/\1/' \
        -e 's/^#\(LoadModule .*mod_proxy.so\)/\1/' \
        -e 's/^#\(LoadModule .*mod_proxy_http.so\)/\1/' \
        -e 's/^#\(LoadModule .*mod_proxy_fcgi.so\)/\1/' \
        -e 's/^#\(LoadModule .*mod_proxy_ajp.so\)/\1/' \
        -e 's/^#\(LoadModule .*mod_dav.so\)/\1/' \
        -e 's/^#\(LoadModule .*mod_dav_fs.so\)/\1/' \
        -e 's/^#\(LoadModule .*mod_dav_lock.so\)/\1/' \
        conf/httpd.conf \
    && mkdir -m 700 /usr/local/apache2/var \
    && chown daemon. /usr/local/apache2/var/ \
    && mkdir -m 700 /usr/local/apache2/uploads \
    && chown daemon. /usr/local/apache2/uploads/ \
    && sed -i \
        -e 's/POST OPTIONS/POST OPTIONS LOCK/g' \
        -e 's/Require user admin/Require user admin/g' \
        conf/extra/httpd-dav.conf \
    && apt-get -y update \
    && apt-get -y install vim
ADD ./user.passwd /usr/local/apache2/
EXPOSE 80
CMD ["httpd-foreground"]