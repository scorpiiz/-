const wxcom = require('../../utils/common.js')

const app=getApp()
Page({
  data: {
    list: [],
    cid:0,
    cname:'',
    cont:'',
	modalName:null,
    isShowlogin:false,
	isload:false,
  },
  //页面加载
  onLoad: function () {
    this.getlist();

  },
  //获取数据
  getlist: function () {
     var that = this
     let para= {f:4,cmd:'baoming_List'};
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
    params.it=e.currentTarget.dataset.it;
	params.zt=e.currentTarget.dataset.f;
    wxcom.savedata(params,this.getlist);
  },
  keyCInput:function(e){
     this.setData({ cont: e.detail.value })
  },
  goshow(e) {
	if(app.globalData.logID>0){
		this.setData({ modalName: e.currentTarget.dataset.n,cid:e.currentTarget.dataset.cid,cname:e.currentTarget.dataset.cname })
	}else {
		wxcom.yzlogin();
	}
  },
  goping(e) {
    let msg="";
	if(this.data.cont) {} else { msg= '请输入打卡内容';}
    if(msg){
	     wx.showToast({title:msg,image: '/images/pic/error.png', duration: 2000})
		}
	else {
		const params ={};
		params.cmd=e.currentTarget.dataset.n;
		params.cid= this.data.cid;
		params.cname= this.data.cname;
		params.cont = this.data.cont;
		params.f=1;
    wxcom.savedata(params,this.getlist);
    this.hideModal();
	}
  }, 
  hideModal() {
    this.setData({ modalName: null })
  }
})
