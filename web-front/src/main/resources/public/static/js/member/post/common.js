$(function() {

	// 多重サブミットを防止
	$.preventDoubleSubmit();

	// プレビュー
	(function() {
		function preview() {
			var isPreview = $('#main').data('preview');
			if (isPreview) {
				openPreviewWindow();
			}
		}
		preview();

		$('.previewBtn').click(function() {
			openPreviewWindow();
		});

		// プレビュー画面を表示する
		function openPreviewWindow() {
			var formClone = $('form').clone();
			formClone.attr('target', 'previewwindow')
			formClone.attr('action', '/wedding/preview/post/')

			$('body').append(formClone);

			try {
				var p = $.popup({url:'about:blank', name:'previewwindow', style:'width=1124px,height=768px,menubar=no,toolbar=no,scrollbars=yes'});
				formClone.submit();
			} catch (e) {
				// Non-Operation
			} finally {
				formClone.remove();
			}
		}
	})();
});