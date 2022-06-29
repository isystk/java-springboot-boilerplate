$(function() {

  const imageSelect = $('.js-image-upload').imageUploader({
    successCallback : function(res) {
      const parent = imageSelect.closest('.image-upload-area');
      parent.find('.upload-image-data').val(res.fileData);
      parent.find('.upload-image-name').val(res.fileName);
      parent.find('.upload-image').attr('src', res.fileData);
    },
  });

})