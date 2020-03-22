$(function() {
	// ログアウト
    $("#logout").bind("click", function() {
        $("form[name='logout']").submit();
    });
});
