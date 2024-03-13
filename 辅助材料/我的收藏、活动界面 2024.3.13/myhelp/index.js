const wxcom = require('../../utils/common.js')

const app=getApp()
Page({
  data: {
    list: [],

    isShowlogin:false,
	isload:false,
  },
  //页面加载
  onLoad: function () {
    wxcom.yzlogin();
   
    this.getlist();

  },
  //获取数据
  getlist: function () {
     var that = this
     let para= {f:4,cmd:'help_List'};
      wxcom.loaddata(para,function(res){
	        that.setData({
          list: res.data.data
		})
	  });
  },
  //页面跳转
  gonav:function(e){
    wx.navigateTo({ url: e.currentTarget.dataset.n })
  },
  
  gofav(e) {
    const params ={};
    params.cmd=e.currentTarget.dataset.n;
    params.id=e.currentTarget.dataset.id;
	params.zt=e.currentTarget.dataset.f;
    params.f=1;
    wxcom.savedata(params,this.getlist);
  }
})
