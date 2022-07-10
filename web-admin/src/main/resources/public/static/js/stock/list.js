$(function() {
  // ダウンロード
  $('.js-download').click(function(e) {
    e.preventDefault();
    var self = $(this),
      href = self.attr('href'),
      form = $('#pagingForm');
    location.href = [href, form.serialize()].join('?');
  });
  // 削除ボタン
  $('.js-delete').click(function(e) {
    if (!confirm('削除します。よろしいですか？')) {
      e.preventDefault();
      return false;
    }
  });
})