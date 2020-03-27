
(function($) {
	/*
	 * jKeyup
	 *
	 * Copyright (c) 2012 iseyoshitaka at isystk.com
	 *
	 * Options:
	 * 　callback
	 *
	 * Description:
	 * 　Windows:Operaは全角文字入力時にkeyup、keydown、keypressが発生しないので
	 * 　その差分を吸収します。
	 * 　callbackの第1引数にtextのvalue、第2引数にOpera以外の場合はeventを渡します。
	 */

	$.fn.jKeyup = function(fn) {
		init($(this), fn);
	};

	function init(elem, fn) {
		var jkeyup = new jKeyup();
		jkeyup.callback = fn ? fn : function() {};
		jkeyup.elem = elem;

		prevent(jkeyup);
	}

	function prevent(s) {
		var elem = s.elem;

		// Operaの場合はTimerで監視
		if ($.browser.opera) {
			elem.focus(function(event) {
					var val = "";
					s.interval = setInterval(function() {
						if (val != elem.val()) {
							val = elem.val();
							s.callback.call(elem, val);
						}
					}, 100);
				})
			.blur(function(event) {
					clearInterval(s.interval);
				});
		} else {
			elem.keyup(function(event) {
				s.callback.call(elem, elem.val(), event);
			});
		}
	}

	function jKeyup() {}
	jKeyup.prototype = {
		elem: null, callback: null, interval: null
	}

})(jQuery);

(function($){
	/*
	 * textCounter
	 *
	 * Copyright (c) 2012 iseyoshitaka at isystk.com
	 *
	 * Options:
	 * selectors
	 *
	 * Description:
	 * 文字数をカウントします
	 * 半角文字・スペース・改行、全角文字は1としてカウントします
	 */
	$.textCounter = function(selectors) {
		var s = selectors;
		for (var i = 0, len = s.length; i < len; ++i)(function() {
			var obj = s[i],
				elem = $(obj.textSelector),
				label = $(obj.labelSelector);

			// カウント数
			label.html(obj.count - getCount(elem.val()));

			// デフォルト色
			label.data('defaultcolor', label.css('color'));

			elem.jKeyup(function(val) {
				var count = obj.count - getCount(elem.val());
				label.html(count);

				if (count <= 0) {
					label.css('color', '#FF0000');
				} else {
					label.css('color', label.data('defaultcolor'));
				}
			});
		})();
	};

	function getCount(val) {
		if (val) {
			var str = val.replace(/[\uD800-\uDBFF][\uDC00-\uDFFF]/g, " ");
			return str.replace(/\n/g, "\r\n").length;
		}
		return 0;
	}

})(jQuery);


(function($){
	/*
	 * popup
	 *
	 * Copyright (c) 2012 iseyoshitaka at isystk.com
	 *
	 * Options:
	 * url - URL
	 * name - window名
	 * style - ポップアップスタイル（例："width=700,height=450,resizable=no,scrollbars=no,status=no,toolbar=no"）
	 *
	 * Description:
	 * window.openのラッパー
	 * 戻り値に開いたwindowを返します
	 */
	$.popup = function(options) {
		var p = new Popup();
		jQuery.extend(p.options, options);
		p.window = window.open(p.options.url, p.options.name, p.options.style);
		return p;
	};

	var Popup = function() {};
	Popup.prototype = {
		window: null,
		options: {
			url: null,
			name: null,
			style: null
		},
		close: function() {
			this.window.close();
		}
	}

})(jQuery);

(function($) {
/*
 * preventDoubleSubmit
 *
 * Copyright (c) 2017 iseyoshitaka at isystk.com
 *
 * Description:
 * 多重サブミットを防止したいときに使用します。
 */
$.preventDoubleSubmit = function() {
	var loading = false;
    $("form").submit(function(e) {
        var self = $(this);
        if (loading) {
        	e.stopPropagation();
        	return　false;
        }
        loading = true;
        setTimeout(function() {
            loading = false;
        }, 10000);
    });
}

})(jQuery);



(function($) {
	/*
	 * mynaviUpload
	 *
	 * Copyright (c) 2017 iseyoshitaka at isystk.com
	 *
	 * Description:
	 * ファイル非同期アップローダー
	 *
	 */
	$.mynaviUpload = function(options) {

		var params = $.extend({}, $.mynaviUpload.defaults, options);

		var init = function(files) {

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
			var fileUpload = this.fileUpload = function (obj, isMovie) {

				// ファイルAPIに対応している場合は、画像チェックとサイズチェックをクライアント側でも行う。
				if (window.File && window.FileReader && window.FileList && window.Blob){
					var errors = [];
					$.each(obj.files, function(i, file){
						if (isMovie) {
							if( !file.type.match('video.*') ){
								errors.push('動画ファイルが不正です。');
							}
							// ファイルサイズチェック
							if( Mynavi.constants.config.client_movie_maxfilesize <= file.size ){
								errors.push('動画ファイルのファイルサイズが最大値(50MB)を超えています。');
							}
						} else {
							// 画像ファイルチェック
							if( !file.type.match("image.*") ){
								errors.push('画像ファイルが不正です。');
							}
							// ファイルサイズチェック
							if( Mynavi.constants.config.client_album_imagefile_maxfilesize <= file.size ){
								errors.push('画像ファイルのファイルサイズが最大値('+ Mynavi.constants.config.client_album_imagefile_maxfilesize/1000000 +'MB)を超えています。');
							}
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
						if (isMovie) {
							formData.append('movieFile', file, file.name);
						} else {
							formData.append('imageFile', file, file.name);
						}
						if (file.imageId) {
							formData.append('imageId', file.imageId);
						}

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

	$.mynaviUpload.defaults = {
		uploadUrl: '',
		contentType : 'image/jpeg',
		successCallback : null,
		errorsCallback : null,
		completeCallback : null
	}

})(jQuery);


(function($) {
	/*
	 * refineSelectBox
	 *
	 * Copyright (c) 2020 iseyoshitaka at isystk.com
	 *
	 * Description:
	 * セレクトボックスの絞り込み用
	 *
	 */
	$.fn.refineSelectBox = function(opts) {

		// 引数に値が存在する場合、デフォルト値を上書きする
		var settings = $.extend({}, $.fn.refineSelectBox.defaults, opts);

		var init = function (obj) {

			var self = $(obj),
				parent = self.closest('div,tr'),
				searchWord = ''; // 絞り込み文字列

			// 絞り込み検索用のテキスト入力欄の追加
			self.before('<input type="text" class="refineText formTextbox" />');
			var refineText = parent.find('.refineText');

			if (settings.mode === MODE.NORMAL) {
				refineText.attr('readonly', 'readonly');
			}

			// 初期表示で選択済みの場合、絞り込み文言入力欄に選択済みの文言を表示
			var selectedOption = self.find('option:selected');
			if(selectedOption){
				refineText.val(selectedOption.text());
				if (selectedOption.val() === '') {
					if (settings.mode === MODE.TAG) {
						refineText.val("");
					}
				}
			}

			// セレクトボックスの代わりに表示するダミーリストを作成
			var searchBoxElement = $('<ul class="searchBoxElement"></ul>');
			searchBoxElement.append(_.map(self.find('option'), function(obj) {
				return '<li data-selected="off" data-dummyVal="' + $(obj).val() + '"><span>' + $(obj).text() + '</span></li>';
			}).join(''));
			searchBoxElement.hide();
			self.after(searchBoxElement);

			// ダミーリストの表示幅をセレクトボックスにあわせる
			var refineTextWidth = (self.width() === 0) ? 250 : self.width();
			refineText.css('width', (refineTextWidth) + 'px');
			searchBoxElement.css('width', (refineTextWidth) + 'px');

			// 元のセレクトボックスは非表示にする
			self.hide();

			// ダミーリスト選択時
			searchBoxElement.find('li').click(function(e){
				e.preventDefault();
				// e.stopPropagation();
				var li = $(this),
					dummyVal = li.data('dummyval');
				self.val(dummyVal).change();
				parent.find('li').attr('data-selected', 'off');
				li.attr('data-selected', 'on');
			});

			// ダミーリストを検索条件で絞り込みます。
			var changesearchBoxElement = function() {
				var visibleTarget = searchBoxElement.find('li');
				visibleTarget.show();
				if (searchWord !== '') {
					var matcher = searchWord.replace(/\\/g, '\\\\');
					visibleTarget = searchBoxElement.find('li').filter(function(){
						return $(this).text().match(matcher);
					});
					searchBoxElement.find('li').hide();
					visibleTarget.show();
				}

				// 選択中のLIタグの背景色を変更します。
				var selectedOption = self.find('option:selected');
				if(selectedOption){
					searchBoxElement.find('li').removeClass('selected');
					searchBoxElement.find('li[data-dummyval="' + selectedOption.val() + '"]').addClass('selected');
				}

				if (0 < visibleTarget.length) {
					searchBoxElement.show();
				} else {
					searchBoxElement.hide();
				}
			};

			// keyup時のファンクション
			refineText.keyup(function(e){
				searchWord = $(this).val();
				// ダミーリストをリフレッシュ
				changesearchBoxElement();
			});

			// セレクトボックス変更時
			self.change(function(){
				// 直近の絞り込み文言エリアへ選択オプションのテキストを反映
				var selectedOption = $(this).find('option:selected');
				searchWord = selectedOption.text();
				refineText.val(selectedOption.text());
				if (selectedOption.val() === '') {
					searchWord = '';
					if (settings.mode === MODE.TAG) {
						refineText.val("");
					}
				}

				if (settings.selectCallback) {
					settings.selectCallback({
						selectOption: selectedOption
					});
				}
			});

			// 絞り込み入力欄をクリックした場合はダミーリストを表示
			refineText.click(function(e) {
				e.preventDefault();

				// モードに合わせて設定
				if (settings.mode === MODE.NORMAL) {
					searchWord = '';
				} else if (settings.mode === MODE.INPUT) {
					refineText.val('');
					searchWord = '';
				} else if (settings.mode === MODE.TAG) {
					var selectedOption = self.find('option:selected');
					if (selectedOption.val() === '') {
						refineText.val('');
						searchWord = '';
					}
				}

				// ダミーリストをリフレッシュ
				$('.searchBoxElement').hide();
				changesearchBoxElement();

			});

			// 表示中のダミーリストを非表示
			$(document).click(function(e){
				if($(e.target).hasClass('refineText')){
					return;
				}
				searchBoxElement.hide();
				if (settings.mode !== MODE.TAG) {
					var selectedOption = self.find('option:selected');
					searchWord = selectedOption.text();
					refineText.val(selectedOption.text());
				}
			});

		}

		$(this).each(function (){
			init(this);
		});

		return this;
	}

	var MODE = {
		NORMAL: 0, // 通常のセレクトボックス
		INPUT: 1, // 入力式セレクトボックス
		TAG: 2 // タグ追加式セレクトボックス
	};

	$.fn.refineSelectBox.defaults = {
		selectCallback: null,
		mode: MODE.INPUT
	};

})(jQuery);


(function($) {
	/*
	 * peopleTagSelect
	 *
	 * Copyright (c) 2018 iseyoshitaka at isystk.com
	 *
	 * Description:
	 * 先輩カップルタグ選択画面の表示
	 *
	 */
	$.fn.peopleTagSelect = function(opts) {

		// 引数に値が存在する場合、デフォルト値を上書きする
		var settings = $.extend({}, $.fn.peopleTagSelect.defaults, opts);

		// パネルの表示位置を調整します。
		var adjustPanelPosition = function (){
			var h = $(window).height();
			var w = $(window).width();
			var ph = $('#dialogPeopleTag').height();
			var pw = $('#dialogPeopleTag').width();
			var scrollTop = $(window).scrollTop();
			var scrollLeft = $(window).scrollLeft();
			$('#dialogPeopleTag').css('top', scrollTop + Math.floor((h - ph)/2) + 'px');
			$('#dialogPeopleTag').css('left', scrollLeft + Math.floor((w - pw)/2) + 'px');
		}
		$(window).resize(function() {
			adjustPanelPosition();
		});

		var init = function(obj) {

			var self = $(obj),
				parent = self.closest('div');

			var loading = false;
			var selectTags = []; // 現在選択中のタグ
			var ngWordList = []; // タグのNGワードリスト
			var panel = $([
				'<div id="dialogPeopleTag">',
				'	<a href="#" class="js-close"><span class="close"></span></a>',
				'	<div class="wrap">',
				'	    <h2 class="capMain">ハッシュタグ選択</h2>',
				'	   <div id="dialogPeopleTag-errorsArea"></div>',
				'		<div class="box" >',
				'			<p class="sub-title">任意のタグを追加</p>',
				'			<div class="user-tag" >',
				'				<select name="peopleTagId"  class="js-refineTarget">',
				'				</select>',
				'				<input type="button" value="追加" class="js-add-tag">',
				'			</div>',
				'		</div>',
				'		<div class="box" >',
				'			<p class="sub-title">追加されるタグ</p>',
				'			<div class="HotHashTag_area_list append-tag">',
				'			</div>',
				'		</div>',
				'		',
				'	</div>',
				'	<p class="btnArea"><input type="button" class="btn-ok" value="設定する"></p>',
				'</div>'
			].join(''));

			panel.appendTo('body');

			panel.find('.js-close').click(function(e) {
				e.preventDefault();
				closeDialog();
			});

			// エラーメッセージを表示します。
			var showErrorMsg = function(errors) {
				var divs = _.map(errors, function(error) {
					return '<p class=\"errortxt\">'+error+'</p>';
				});
				$('#dialogPeopleTag-errorsArea').empty().append('<div class=\"alertBox\">' + divs.join('') + '</div>');
			};

			panel.find('.btn-ok').click(function(e) {
				e.preventDefault();
				var self = $(this);

				if (loading) {
					return ;
				}
				loading = true;

				var url = '/member/post/checkTagList/';

				var form = $('<form></form>');
				form.append($(_.map(selectTags, function(data) {
					return '<input type="hidden" name="selectTags" value="'+ data +'" />';
				}).join('')));

				// Loading画像
				$('<div id="site_loader_overlay"><div class="site_loader_spinner" ></div></div>').appendTo('body');

				$.ajax({
					type: 'post',
					data: form.serialize(),
					url : url,
					cache : false,
					success: function(data){

						if (!data.success) {

							var error = data.message;
							showErrorMsg([error]);

							// Loading画像
							$('#site_loader_overlay').remove();

							loading = false;
							return false;
						}

						var setTagList = data.responseData.setTagList;

						// 選択済みのタグを呼び出し元画面に表示する
						(function() {
							parent.find('.select-tag').empty();
							parent.find('.select-tag').html(_.map(setTagList, function(data) {
								return [
									'<input type="hidden" name="postTagId" value="'+data.postTagId+'" />',
									'<li><a href="#" class="btn_hotHashTag">'+data.name+'</a></li>'
									].join('');
							}).join(''));
						})();

						// Loading画像
						$('#site_loader_overlay').remove();

						closeDialog();
						loading = false;

						if (settings.okCallback) {
							settings.okCallback();
						}
					},
					error: function() {
						closeDialog();
						loading = false;
						return false;
					}
				});

			});

			// ダイアログ非表示
			var showDialog = this.showDialog = function(selectTagHtml) {
				if ($('#dialog-overlay').length === 0) {
					$('body').append('<div id="dialog-overlay"></div>');
					$('#dialog-overlay').click(function() {
						closeDialog();
					});
				}

				panel.addClass('open');
				$('#dialog-overlay').fadeIn();

				var url = '/member/post/tagList/';

				// Loading画像
				$('<div id="site_loader_overlay"><div class="site_loader_spinner" ></div></div>').appendTo('body');

				$.ajax({
					type: 'get',
					url : url,
					cache : false,
					success: function(data){

						if (!data.responseData) {
							closeDialog();
							return false;
						}

						var allTagList = data.responseData.allTagList;
						ngWordList = data.responseData.ngWordList;

						// 「任意のタグから追加」の項目を表示
						if (panel.find('.refineText').length === 0) {
							panel.find('.js-refineTarget').html(
									'<option value="">-----</option>' +
									_.map(allTagList, function(data) {
								return '<option value="'+data.postTagId+'">'+data.name+'</option>';
							}).join(''));
							// タグの絞り込み検索
							panel.find('.js-refineTarget').refineSelectBox({
								mode: 2
							});
						}

						// 任意のタグを追加
						panel.find('.js-add-tag').click(function(e) {
							e.preventDefault();
							var refineText = sanitaize.encode(panel.find('.refineText').val());
							if (!validate(refineText)) {
								return false;
							}
							selectTags.push(refineText);
							panel.find('.append-tag').append($('<li><a href="#" class="js-close btn_hotHashTag with_crossBtn_over">'+refineText+'</a></li>'));
							panel.find('.refineText').val('');
							panel.find('.js-refineTarget').val('').change();
						});

						// 選択中のタグを表示する
						(function() {
							// 選択中のタグ
							var selectTagNameList = _.map(selectTagHtml.find('a.btn_hotHashTag'), function(data) {
								return $(data).text();
							});

							// 選択中のタグ任意タグを追加
							selectTags = _.union(selectTags, selectTagNameList);

							panel.find('.append-tag').empty();
							panel.find('.append-tag').append(_.map(selectTagNameList, function(data) {
								return '<li><a href="#" class="js-close btn_hotHashTag with_crossBtn_over">'+data+'</a></li>';
							}).join(''));
						})();

						// 選択中のタグを削除する
						$(document).on('click', '#dialogPeopleTag .append-tag .js-close', function(e) {
							e.preventDefault();
							selectTags = _.without(selectTags, $(this).text());
							$(this).remove();
						});

						// Loading画像
						$('#site_loader_overlay').remove();
					},
					error: function() {
						closeDialog();
						return false;
					}
				});

			}

			// 入力チェック
			var validate = function(val) {
				if (val === '') {
					alert('空のタグは設定できません。');
					return false;
				}
				if (_.contains(selectTags,val)) {
					alert('同じタグは設定できません。');
					return false;
				}
				if (_.contains(ngWordList,val)) {
					alert('['+val+']はNGワードの為設定できません。');
					return false;
				}
				return true;
			}

			// 最低限のサニタイズ処理
			var sanitaize = {
			  encode : function (str) {
			    return str.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '&quot;').replace(/'/g, '&#39;');
			  },

			  decode : function (str) {
			    return str.replace(/&lt;/g, '<').replace(/&gt;/g, '>').replace(/&quot;/g, '"').replace(/&#39;/g, '\'').replace(/&amp;/g, '&');
			  }
			};

			// ダイアログ非表示
			var closeDialog = function() {
				loading = false;
				$('#dialogPeopleTag').removeClass('open');
				$('#dialog-overlay').fadeOut();

				if (settings.closeCallback) {
					settings.closeCallback();
				}
			}

			// 表示位置の調整
			adjustPanelPosition();

			return this;
		}

		$(this).each(function() {
			// タグ選択ボタン押下時にパネル表示
			$(this).click(function(e) {
				e.preventDefault();
				var self = $(this),
					selectTagHtml = self.closest('div').find('.select-tag') || '';
				$('#dialogPeopleTag').remove();
				var obj = new init(self);
				obj.showDialog(selectTagHtml);
			});
		});

		return this;
	}

	$.fn.peopleTagSelect.defaults = {
		closeCallback: null, // 画面を閉じた際のコールバック
		okCallback: null // 設定完了後のコールバック
	};

})(jQuery);

(function($){
	/*
	 * mynaviRealtimeCheck
	 *
	 * Copyright (c) 2012 iseyoshitaka at isystk.com
	 *
	 * Description:
	 * テキストボックスに入力された値をAjaxから呼出しでvalidateチェックする機能を提供します
	 *
	 * ＜エラー出力用divタグの命名規則＞
	 *   「テキストボックスのname + "ErrMessage"」とする。
	 *     exp. 参加人数「joinCnt」の場合「joinCntErrMessage」とする必要がある。
	 *
	 * Sample:
	 * 	$.mynaviRealtimeCheck({'textselector': '.realtimecheck', 'url': '/wedding/inquiry/fair/callRealtimeCheck/'});
	 *
	 */
	// デフォルト値
	var options = {
		wrapselector  : document,
		textselector  : ".realtimecheck",
		url           : ""
	};

	$.mynaviRealtimeCheck = function(opts) {

		// 引数に値が存在する場合、デフォルト値を上書きする
		$.extend(options, opts);

		// optionsのスコープ内で、検索しイベントを設定する
		$(options.wrapselector).find(options.textselector).change(function(event) {

			// イベントをキャンセルする
			event.preventDefault();

			// 対象のテキストボックス
			var thisInput = $(this);
			var form = thisInput.closest('form');
			var propertyName = form.find('input[name=propertyName]');
			var propertyValue = form.find('input[name=propertyValue]');
			if (0 < propertyName.length) {
				propertyName.val(thisInput.attr('name'));
			} else {
				$('<input type="hidden" name="propertyName" />').val(thisInput.attr('name')).appendTo(form);
			}
			if (0 < propertyValue.length) {
				propertyValue.val(thisInput.val());
			} else {
				$('<input type="hidden" name="propertyValue" />').val(thisInput.val()).appendTo(form);
			}

			var host = Mynavi.constants.url.domain || '';
			if (host !== '') {
				host = location.protocol + '//' + host;
			}
			// Ajax通信を行う
			$.ajax({
				type: 'POST',
				url : host + options.url,
				cache : false,
				dataType : 'json',
				data : form.serialize(),
				success: function(data){
					// Ajax 通信成功時

					// '(', ')'が含まれていた場合にエスケープする
					// e.g. ( ⇒ \(
					var inputName = thisInput.attr('name').replace(/\(/, '\\\(').replace(/\)/, '\\\)');
					// エラー出力を行うdivタグを定義する
					var errDiv = $('[id="' + inputName + 'ErrMessage"]');
	                // エラースタイルの初期化
					thisInput.removeClass("error");
	                // エラー出力を行うdivタグの初期化
					errDiv.html('');

					if (!$.isEmptyObject(data.message)) {
		                // エラースタイルを設定
						thisInput.addClass("error");

		                // メッセージ内容をdivタグに設定
						var messages = '';
						for (var i = 0; i < data.message.length; i++) {
							messages = messages + '<p class="errortxt">'+data.message[i]+'</p>'
						}
						errDiv.html(messages);

//						errDiv.html('<p class="errortxt">'+data.message+'</p>');
					}
				},
				error: function(XHR, textStatus, errorThrown) {
					 if(XHR.readyState == 0 || XHR.status == 0)
			              return;  // ページ遷移中のためのエラーの場合は即座にリターン

					// Ajax 通信失敗時
					alert('リアルタイムチェックの呼び出しに失敗しました。');
				}
			});
		});
	};
})(jQuery);

