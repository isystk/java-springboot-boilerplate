$(function() {

	// ハッシュタグ選択画面
	$('.js-tag-select').peopleTagSelect();

	// テキストカウンタ
	$('.js-textCounter').each(function() {
		var self = $(this),
			maxlength = self.text() || '0',
			text = self.closest('div').find('input,textarea');
		$.textCounter([{textSelector: text, labelSelector: self, count: maxlength}]);
	});

	// 画像ファイルアップロード
	(function() {

		// エラーメッセージを表示します。
		var showErrorMsg = function(dataType, errors) {
			var divs = _.map(errors, function(error) {
				return '<p class=\"errortxt\">'+error+'</p>';
			});
			var errDiv = $('[id="' + dataType + 'IdErrMessage"]');
			errDiv.empty().append('<div class=\"alertBox\">' + divs.join('') + '</div>');
		};

		// カテゴリー写真ファイル選択時
		$('.js-upload-postImage-btn').change(function(){

			var dataType = 'postImage';

			var slides = $('.selectedPhotoList'),
				imagesLength = slides.find('li').length;
			var fileLength = this.files.length;
			if (10 < (imagesLength + fileLength)) {
				showErrorMsg(dataType, ['コンテンツ写真の登録可能件数は、最大10件です。']);
				return;
			}

			// Loading画像
			$('<div id="site_loader_overlay"><div class="site_loader_spinner" ></div></div>').appendTo('body');

			var count = 0;
			imageUpload(this, dataType, function(res) {

				if (!res) {
					// Loading画像
					$('#site_loader_overlay').remove();
					return false;
				}

		    	// 画像をアニメーション（フェードイン）で表示します。
				var src = res.imageFullpath + '?time=' + new Date().getTime();
				var image = $([
					'<li><a href="#" class="close">',
						'<img src="'+src+'" width="120px" />',
						'<input type="hidden" name="postImageId" value="'+res.imageId+'" />',
					'</a></li>'
					].join(''));
				slides.append(image);

				count = count + 1;
				if (fileLength == count) {
					// エラーメッセージを消す
					$('[id="addCategoryList[0].' + dataType + 'IdErrMessage"]').empty();

					// Loading画像
					$('#site_loader_overlay').remove();
				}
			});
		});

		// 画像ファイル選択時
		var imageUpload = function(file, dataType, callbackfunc){
			var self = $(file);

			// 未選択の場合は何もしない。
			if (self.val() === '') {
				return;
			}

			// アップロード中は、「ファイル選択」ボタンを非活性にする。
			self.attr('disabled', 'disabled');

			$.mynaviUpload({
				uploadUrl: '/member/post/imageUpload/?dataType=' + dataType,
				successCallback : function(res) {

					self.removeAttr('disabled');

					// エラー処理
					$('#errorsArea').empty();
					$('input','select').removeClass('error');
					if (res.errors) {
						showErrorMsg(dataType, res.errors);
						return false;
					}

					if (callbackfunc) {
						callbackfunc(res);
					}

				},
				errorsCallback : function(errors) {
					self.removeAttr('disabled');

		            if (callbackfunc) {
		            	callbackfunc();
		            }

					showErrorMsg(dataType, errors);
					return false;
				}

		    }).fileUpload(file);

		};

	})();

	// 選択中の画像を削除する
	$(document).on('click', '.selectedPhotoList a.close', function(e) {
		e.preventDefault();
		$(this).closest('li').remove();
	});

	// リアルタイムチェック
	$.mynaviRealtimeCheck({'textselector': '.realtimecheck', 'url': '/member/post/regist/callRealtimeCheck/'});


});