var isystkMixin = {
	filters: {
		sanitaize: function(value) {
			if (!value) return ''
			value = value.toString()
			return value.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '&quot;').replace(/'/g, '&#39;');
		},
		nl2br: function(value) {
			if (!value) return ''
			value = value.toString()
			return value.replace(/\n/g, '<br/>');
		},
	}
};