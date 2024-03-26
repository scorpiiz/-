const app = getApp();
Component({
    /**
   * 组件的一些选项
   */
    options: {
        addGlobalClass: true,
        multipleSlots: true
    },
    /**
   * 组件的对外属性
   */

    properties: {
        bgColor: {
            type: String,
            default: ''
        },
        isCustom: {
            type: [Boolean, String],
            default: false
        },
        isBack: {
            type: [Boolean, String],
            default: false
        },
        bgImage: {
            type: String,
            default: ''
        },
    },
    /**
   * 组件的初始数据
   */
    data: {
        StatusBar: app.globalData.StatusBar,
        CustomBar: app.globalData.CustomBar,
        Custom: app.globalData.Custom
    },
    /**
   * 组件的方法列表
   */
    methods: {
        BackPage() {
            let pages = getCurrentPages() 
            let url = pages[pages.length-1].route
             console.log('需要销毁的页面：'+url);
            if(url.indexOf("order/index")>-1 && pages.length>2 )
            {
            wx.switchTab({url: '../index/index'})
            }
            else if(url.indexOf("mall/index")>-1)
            {
            wx.switchTab({url: '../index/index'})
            }
    else 
        {  
        wx.navigateBack({
        delta: 1
      });
}
  

    },
    toHome(){
      wx.reLaunch({
        url: '/pages/index/index',
      })
    },
    
  }
})