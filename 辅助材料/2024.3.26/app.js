//app.js
App({
  
  onLaunch: function () {
    wx.getSystemInfo({
      success: e => {
        this.globalData.StatusBar = e.statusBarHeight;
        let capsule = wx.getMenuButtonBoundingClientRect();
        if (capsule) {
          this.globalData.Custom = capsule;
          this.globalData.CustomBar = capsule.bottom + capsule.top - e.statusBarHeight;
        } else {
          this.globalData.CustomBar = e.statusBarHeight + 50;
        }
      }
    })
  },

  globalData: {
    userInfo: null,
    apiurl:'http://localhost:8080/PetHelpServiceServer/', 
    isHasuser:0, 
    skey:'1',
    isLog:0,
    iscLog:0,
    ids:[],
    sname:'',
	stype:0,
    cid:0,
    tid:0,
    pos:'',
	fee:0,
    fname:'',
	pic:'',
    pz:'',
    logID:0

  }
})