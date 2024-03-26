const app = getApp()//获取应用实例
const util = require('util.js')
const apiurl= app.globalData.apiurl;//接口调用地址
//接口调用
const loaddata = (para,callback) => {
    let data=para || {};
	let isttip = data.isttip || 0;
    let type = data.type || 'post';
    let cmd= data.cmd || '';
    data.skey=app.globalData.skey;
    data.uuid=app.globalData.logID;
    data.uuname=app.globalData.sname;
    //data.uutype=app.globalData.stype;
    //console.log(app.globalData);
    if(data.skey !=null && data.skey.length>0)
    {
      wx.request({
        url: apiurl+cmd+".action",
        data:data,
        method:type,
        header:{"content-type": "application/x-www-form-urlencoded"},
        success (res) {
          console.log(res.data);
			  if(res.data.code==0 && cmd=="user_Login"){
				  if(res.data.uuid){
						app.globalData.isLog = 3; 
						app.globalData.logID = res.data.uuid; 
						app.globalData.sname = res.data.tip; 
						//app.globalData.pos = res.data.tip; 
						//app.globalData.stype = res.data.total; 
						app.globalData.skey = '1'; 
				   }
                   console.log(app.globalData);
               }

              if(isttip==1){wtip(res,callback);}
			  else if(callback) {  
					console.log(res);
					callback(res);  
			  }
		}
      })
    }
}
  
const savedata = (para,callback) => {
    para.isttip=1;
    loaddata(para,callback);
}

const wtip = (res,callback) => {
    let msg=res.data.msg;
    wx.showModal({
		   title: '操作提示',
		   content: msg,
		   showCancel:false,
		   success (rres) {
		   if (rres.confirm && res.data.code==0) {
			   if(callback){callback();}
			 }
		   }
       })
}

const getRandomColor=()=>{
  let rgb = []
  for (let i = 0; i < 3; ++i) {
    let color = Math.floor(Math.random() * 256).toString(16)
    color = color.length === 1 ? '0' + color : color
    rgb.push(color)
  }
  return '#' + rgb.join('')
}


   const nav = (url) => { wx.navigateTo({url: url}) }
   const go = (url) =>  { wx.redirectTo({url: url}) }
   const tab = (url) => { wx.switchTab({url: url}) }
   const tip = (msg) => { wx.showModal({title: '操作提示',content: msg,showCancel:false }) }
   const call = (tel) => { wx.makePhoneCall({phoneNumber: tel }) }


    //文件上传
    const updata=(para,id,dtime,that,callback)=>{
    console.log(para);
     wx.uploadFile({
    filePath: para,
    name: 'file',
    url: apiurl+'file_Up.action?pic='+dtime+'&uid='+app.globalData.logID,
    formData: {
    'des': dtime
		},
    //complete: (res) => {},
    //formData: formData,
    success: (res) => {
    console.log(res.data);
    if (callback) {  
    let resdata=JSON.parse(res.data);
    //resdata.id=id;
    console.log(resdata);
    callback(1,dtime,resdata);  
    //callback(JSON.parse(res.data));  
}
},
    fail: (res) => {
    console.log(res);
    if (callback) {  
    callback(0,dtime,res);  
}
},
})


}

const yzlogin=()=>{
  if(app.globalData.logID==0){
     wx.showModal({
		title: '登录提示',
		content: '请先登录',
		showCancel:false,
		success (res) {
		  if (res.confirm) {
			 console.log('用户点击确定')
			 wx.switchTab({ url: "../index/index"});
		  } 
		}
     })
  }
}



    module.exports = {
    loaddata: loaddata,
    savedata:savedata,
    updata:updata,
    wtip:wtip,
    nav:nav,
    go:go,
	tav:tab,
    tip:tip,
    yzlogin: yzlogin,
    call: call,
    getRandomColor:getRandomColor,

		
}