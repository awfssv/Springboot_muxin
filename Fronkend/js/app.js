window.app = {
	/**
	 * netty服务后端发布的url地址
	 */
	//nettyServerUrl: 'ws://192.168.43.185:8088/ws',
	
	/**
	 * 后端服务发布的url地址
	 */
	serverUrl: 'http://192.168.43.185:8080',
	
	/**
	 * 图片服务器的url地址
	 */
	//imgServerUrl: 'http://192.168.43.185:88/imooc/',
	
	isNotNull: function(str) {
		if (str != null && str != "" && str != undefined) {
			return true;
		}
		return false;
	},
	
	/**
	* 封装消息提示框，默认mui的不支持居中和自定义icon，所以使用h5+
	* @param {Object} msg
	* @param {Object} type
	*/
	showToast: function(msg, type) {
		plus.nativeUI.toast(msg, 
			{icon: "image/" + type + ".png", verticalAlign: "center"})
	},
	/**
	* 保存用户的全局对象
	* @param {Object} user
	*/
	setUserGlobalInfo: function(user) {
		var userInfoStr = JSON.stringify(user);
		plus.storage.setItem("userInfo", userInfoStr);
	},
	
	/**
	* 获取用户的全局对象
	*/
	getUserGlobalInfo: function() {
		var userInfoStr = plus.storage.getItem("userInfo");
		return JSON.parse(userInfoStr);
	},
	/**
	* 登出后，移除用户全局对象
	*/
	userLogout: function() {
		plus.storage.removeItem("userInfo");
	},
	
}
