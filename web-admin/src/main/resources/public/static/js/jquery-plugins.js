
(function($) {
	/*
	 * submitbutton
	 *
	 * Description:
	 * data-uri属性の値を元に画面遷移するようにします。
	 */
	$.fn.submitbutton = function() {
		var loading = false;
		$(this).click(function(e) {
			e.preventDefault();
			e.stopPropagation();
			var self = $(this),
				form = self.closest('form');

			if (loading) {
				e.stopPropagation();
				return　false;
			}
			// Loading画像
			$('<div id="site_loader_overlay"><div class="site_loader_spinner" ></div></div>').appendTo('body');
			loading = true;
			setTimeout(function() {
				loading = false;
			}, 10000);

			form.attr('action', self.data('uri'));
			form.submit();
		});
	}

})(jQuery);

(function($) {
	/*
	 * imageUpload
	 *
	 * Copyright (c) 2017 iseyoshitaka at isystk.com
	 *
	 * Description:
	 * ファイル非同期アップローダー
	 *
	 */
	$.imageUpload = function(options) {

		var params = $.extend({}, $.imageUpload.defaults, options);

		var init = function(files) {

			var form = params.form;
			var uploadUrl = params.uploadUrl;
			var contentType = params.contentType;
			var successCallback = params.successCallback;
			var errorsCallback = params.errorsCallback;
			var completeCallback = params.completeCallback;

			// 画像URLからファイルをアップロード
			this.imageUrlUpload = function(imagePath, imageId) {

				// 画像をロード
				var img = $('<img>');
				img
					.load(function() {
						var o_width = img[0].width;
						var o_height = img[0].height;

						// canvasに書き出し
						var canvas = document.createElement('canvas');
						canvas.width  = o_width;
						canvas.height = o_height;
						var ctx = canvas.getContext('2d');
						ctx.drawImage(img[0], 0, 0);
						var base64 = canvas.toDataURL(contentType);

						// Base64からバイナリへ変換
						var byteString = atob(base64.replace(/^.*,/, ''));

						// バイナリからBlob へ変換
						var arrayBuffer = new ArrayBuffer(byteString.length);
						var intArray = new Uint8Array(arrayBuffer);
						for (var i = 0; i < byteString.length; i++) {
							intArray[i] = byteString.charCodeAt(i);
						}
						var blob = new Blob([intArray.buffer], {type: contentType});
						blob.name = imagePath.substring(imagePath.lastIndexOf('/')+1).replace(/(.*)\.(.*)\?(.*)$/, '$1.$2');
						blob.imageId = imageId;

						var files = [blob];
						var obj = {files : files};

						fileUpload(obj);
					});
				img.attr('src', imagePath);
			};

			// ファイルのアップロード
			var fileUpload = this.fileUpload = function (obj, csrf) {

				// ファイルAPIに対応している場合は、画像チェックとサイズチェックをクライアント側でも行う。
				if (window.File && window.FileReader && window.FileList && window.Blob){
					var errors = [];
					$.each(obj.files, function(i, file){
						// 画像ファイルチェック
						if( !file.type.match("image.*") ){
							errors.push('画像ファイルが不正です。');
						}
					});

					if (0 < errors.length) {
						if (errorsCallback) {
							errorsCallback(errors);
						}

						return false;
					}
				}

				// 60秒以内にレスポンスがない場合は、タイムアウトメッセージを表示する。
				var timer = setTimeout( function() {
					var errors = [];
					errors.push('タイムアウトが発生しました。');

					if (errorsCallback) {
						errorsCallback(errors);
					}

					return false;
				}, 60000);

				var def = $.Deferred();
				var promise = def;

				// ファイル分タスクを作成
				$.each(obj.files, function(i, file){

					promise = promise.pipe(function(response){

						var newPromise = $.Deferred();

						var formData = new FormData();
						formData.enctype = 'multipart/form-data';
						formData.append('_csrf', csrf);
						formData.append('imageFile', file, file.name);

						$.ajax({
							url: uploadUrl,
							type: 'POST',
							dataType: 'json',
							data: formData,
							cache: false,
							contentType: false,
							processData: false,
							success: function(res) {

								clearInterval(timer);

								if (successCallback) {
									successCallback(res);
								}

							},
							error: function(xhr, textStatus, errorThrown) {
								var res = {};
								try {
									res = $.parseJSON(xhr.responseText);
								} catch (e) {}
								alert(res.errorMessage);
							},
							complete: function() {
								newPromise.resolve();

								if (completeCallback) {
									completeCallback();
								}

							}
						});
						return newPromise;
					});
				});
				def.resolve();
			};

		};

		return new init();
	}

	$.imageUpload.defaults = {
		uploadUrl: '',
		form: null,
		contentType : 'image/jpeg',
		successCallback : null,
		errorsCallback : null,
		completeCallback : null
	}

})(jQuery);

