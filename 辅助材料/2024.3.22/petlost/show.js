const wxcom = require('../../utils/common.js')

const app=getApp()
Page({
  data: {
    id: 0,
    item: {},
    list: [],
    isfind:false,
    isShowlogin:false,
  isload:false,
  picurl:'',
  uid:0,
  },
  //页面加载
  onLoad: function (options) {
     this.setData({
         id:options.id,picurl:app.globalData.apiurl,uid:app.globalData.logID
     })
    this.getlist();
  },
  onShow:function () {
    if(this.data.id){
      this.getlist();
    }
  },
  //获取数据
  getlist: function () {
     var that = this
     let para= {f:3,cmd:'petlost_List',id:this.data.id};
      wxcom.loaddata(para,function(res){
	        that.setData({
			  list: res.data.data2,
			  isfind:res.data.total>0,
			  item: res.data.data
		   })
	  });
  },
  //页面跳转
  gonav:function(e){
    wx.navigateTo({ url: e.currentTarget.dataset.n })
  },
  gocall(e) {
    const params ={};
    let tel=e.currentTarget.dataset.n;
	if(this.data.isfind){
	  wxcom.call(tel);
	}
	else {
	  let msg=app.globalData.logID>0?"请先上传寻回凭证":"请先登录";
	  wxcom.tip(msg);
	}
  },
  //查看图片
  ViewImage(e) {
    wx.previewImage({
      current: e.currentTarget.dataset.url
    });
  },
  gofav(e) {
    const params ={};
    params.cmd=e.currentTarget.dataset.n;
    params.zt=e.currentTarget.dataset.f;
	params.id=e.currentTarget.dataset.id;
	params.cid=e.currentTarget.dataset.cid;
    params.f=1;

    wxcom.savedata(params,this.getlist);
  }
})
