const wxcom = require('../../utils/common.js')
import WxValidate from '../../utils/WxValidate.js'

const app=getApp()
Page({
  data: {
    isSubmit: false,
    pic: '',
    imgList: [],

    isShowlogin:false,
	isload:false,
  },
  //页面加载
  onLoad: function () {
    this.initValidate();
  },
  //图片上传
  ChooseImage() {
    wx.chooseImage({
      count: 5, //默认9
      sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album','camera'], //从相册选择
      success: (res) => {
		wxcom.updata(res.tempFilePaths[0],0,this.data.pic,this,this.bindpic);
      }
    });
  },
 //上传后显示图片
 bindpic:function(t,dtime,resdata){
	 var that = this
	 if(t==1){ //console.log(resdata);
		that.setData({imgList: resdata.data,pic: resdata.msg})
	 }
	 else {
		wx.showModal({title: '操作提示',content: resdata.msg,showCancel:false });   
	 }
 },
 //查看图片
 ViewImage(e) {
    wx.previewImage({
      urls: this.data.imgList,
      current: e.currentTarget.dataset.url
    });
  },
  //删除图片
  DelImg(e) {
    wx.showModal({
      title: '图片删除',
      content: '确定要删除吗？',
      cancelText: '取消',
      confirmText: '确定',
      success: res => {
        if (res.confirm) {
          //this.data.imgList.splice(e.currentTarget.dataset.index, 1);
        let param= {};
        param.cmd="file_Del";
        param.delpic = e.currentTarget.dataset.pic;
        param.pic = this.data.pic;
        wxcom.loaddata(param,this.binddelpic);
        }
      }
    })
  },
 //删除后绑定数据
 binddelpic:function(res){
	var that = this
	that.setData({imgList: res.data.data,pic: res.data.msg})
 },
  //表单提交
  formSubmit(e)
  {
    
    if(this.data.isSubmit){
      return false;
    }
    this.setData({ isSubmit: true })
    const params = e.detail.value
    //console.log(params)
    if (!this.WxValidate.checkForm(params)) {
      const error = this.WxValidate.errorList[0]
      wx.showToast({
        title: `${error.msg} `,
        image: '/images/pic/error.png',
        duration: 2000
      })
      this.setData({ isSubmit: false })
      return false
    }
    params.pic= this.data.pic;

    params.cmd='petlost_Add';

    wxcom.savedata(params,this.gourl);
    this.setData({ isSubmit: false })
  },
  //页面跳转
  gourl(){
    wx.navigateBack({delta:1});
  },
initValidate() {
    // 验证字段的规则
    const rules = {
     pname: {
        required: true,
      },
     fee: {
        required: true,
      },
     man: {
        required: true,
      },
     cont: {
        required: true,
      }
    }
    // 验证字段的提示信息，若不传则调用默认的信息
    const messages = {
     pname: {
        required: '请输入主题',
      },
     fee: {
        required: '请输入费用',
      },
     man: {
        required: '请输入发布人',
      },
     cont: {
        required: '请输入介绍',
      }
    }
    // 创建实例对象
    this.WxValidate = new WxValidate(rules, messages)
}
})
