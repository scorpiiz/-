//index.js
//获取应用实例
const wxcom = require('../../utils/common.js')
import WxValidate from '../../utils/WxValidate.js'

Page({
  data: {
    isShowlogin:false,
    isload:false,
    isSubmit:false,
    para:{
      pageindex:1,
      pagesize:3,
      isneedlogin:1,
	  f:1,
      cmd:'user_List'
      },
      item: {
        avatarUrl:'../../images/pic/avatar.png',
        nickName:'用户名'
      }
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },
  onLoad: function () {
    var that = this
    //wxcom.loaddata(that.data.para,that.binddata);
    that.initValidate();
    //wxcom.getislogin(null,that.showlogin);
  },
 //显示登陆
  showlogin:function (t){
      var that = this
        that.setData({
          isShowlogin:t==-1
          })
  },
  getuser: function () {
    var that = this
    wxcom.loaddata(that.data.para,that.binddata);
    //wxcom.getislogin(null,that.showlogin);
    that.userInfoReadyCallback = res => {
      that.setData({
        isShowlogin: false
      })
    }
  },
  binddata:function(res)
  {
    console.log(res);
      var that = this
      that.setData({
          item:res.data.data,
          isload:false,
        })
  },
  tipdata:function(res)
  {
      let msg=res.data.code==0?"成功了":res.data.msg
      console.log(res)
      wx.showModal({
        title: '操作提示',
        content: msg
      })
      this.setData({ isSubmit: false })
      this.setData({ submitHidden: true })
  },
  formSubmit(e)
  {
    if(this.data.isSubmit)
    {
      return false;
    }
    this.setData({ isSubmit: true })

    const params = e.detail.value
    console.log(params)
    if (!this.WxValidate.checkForm(params)) {
      const error = this.WxValidate.errorList[0]
      // `${error.param} : ${error.msg} `
      wx.showToast({
        title: `${error.msg} `,
        image: '/images/pic/error.png',
        //icon: 'warn',  // 
        duration: 2000
      })
      this.setData({ isSubmit: false })
      return false
    }
    this.setData({ submitHidden: false })
    params.cmd='user_Edit';
	params.f=2;
    params.isneedlogin=1;
    wxcom.loaddata(params,this.tipdata);
  },
  initValidate() {
    // 验证字段的规则
    const rules = {
        upass1: {
            required: true,
        },
        upass: {
            required: true,
        },
        confirmuserpass: {
            required: true,
            equalTo: 'upass',
        },
        
    }

    // 验证字段的提示信息，若不传则调用默认的信息
    const messages = {
       upass1: {
            required: '请输入原始密码',
        },
        upass: {
             required: '请输入新密码',
        },
        confirmuserpass: {
          required: '请输入确认密码',
             equalTo: '确认密码和新密码保持一致',
        },

      /*
        password: {
            required: '请输入新密码',
            minlength: '密码长度不少于6位',
            maxlength: '密码长度不多于15位',
        },
        confirmPassword: {
            required: '请输入确认密码',
            minlength: '密码长度不少于6位',
            maxlength: '密码长度不多于15位',
            equalTo: '确认密码和新密码保持一致',
        },
      */
    }

    // 创建实例对象
    this.WxValidate = new WxValidate(rules, messages)
    /*
    // 自定义验证规则
    this.WxValidate.addMethod('assistance', (value, param) => {
        return this.WxValidate.optional(value) || (value.length >= 1 && value.length <= 2)
    }, '请勾选1-2个敲码助手')
    */
}
})
