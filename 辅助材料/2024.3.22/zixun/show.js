const wxcom = require('../../utils/common.js')

const app=getApp()
Page({
  data: {
    id: 0,
    item: {},
    list: [],

    isShowlogin:false,
	isload:false,
  },
  //页面加载
  onLoad: function (options) {
    wxcom.yzlogin();
     this.setData({
         id:options.id
     })
    this.getlist();

  },
  //获取数据
  getlist: function () {
     var that = this
     let para= {f:3,cmd:'zixun_List',id:this.data.id};
      wxcom.loaddata(para,function(res){
	        that.setData({
				 item: res.data.data
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
	params.cid= this.data.item.id;
	params.cname= this.data.item.bt;
    params.f=1;
    wxcom.savedata(params,this.getlist);
  }
})
