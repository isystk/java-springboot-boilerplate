$(function() {
  // 削除ボタン
  $('.js-delete').click(function(e) {
    if (!confirm('削除します。よろしいですか？')) {
      e.preventDefault();
      return false;
    }
  });
})