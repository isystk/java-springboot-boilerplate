$(function() {

  // ログアウト
  $("#logout").bind("click", function() {
    $("form[name='logout']").submit();
  });

  // サイドメニューの開閉制御
  (function() {
    var path = '/admin';　
    $('.js-pushmenu').on('click', function() {
      if ($('body').hasClass('sidebar-collapse')) {
        document.cookie = "sidebarToggleState=opened; path=" + path + ";";
      } else {
        document.cookie = "sidebarToggleState=closed; path=" + path + ";";
      }
    });
    var re = new RegExp('sidebarToggleState' + "=([^;]+)");
    var value = re.exec(document.cookie);
    var toggleState = (value != null) ? unescape(value[1]) : null;
    if (toggleState == 'closed') {
      $('body').addClass('sidebar-collapse');
    }
  })();

  // サブミットボタンの制御
  $('.js-submit').submitbutton();

});
