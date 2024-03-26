const formatTime = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return [year, month, day].map(formatNumber).join('/') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : '0' + n
}


function formatSecondsTime(seconds) {
	if(seconds>0){
	  var second = seconds % 60;
	  var minute = Math.floor(seconds / 60) % 60;
	  var hour = Math.floor(seconds / 3600) % 60;
	  if(hour>0)
		{
		 return hour+"小时"+minute+"分"+second+"秒";
		}
	    return minute+"分"+second+"秒";
	}
	return "0分0秒";
  //return [hour, minute, second].map(formatNumber).join(':')
}


function formatSecondsDay(seconds) {

  var day = Math.floor(seconds / (3600*24));
	return day+"天";
  //return [hour, minute, second].map(formatNumber).join(':')
}

function getSeconds(btime,etime) {
  return Math.floor((new Date(etime.replace("-","/").replace("-","/").replace("-","/"))- new Date(btime.replace("-","/").replace("-","/").replace("-","/"))) / 1000);
}

function getfee(btime,etime,fee)
{
 return formatSecondsFee(getSeconds(btime,etime),fee)
}

function getbhour(btime,etime)
{
  return formatSecondsTime(getSeconds(btime,etime));
}

function getbday(btime,etime)
{
  return formatSecondsDay(getSeconds(btime,etime));
}

function gethour()
{
  let date=new Date();
  return  date.getHours()
}

function getday()
{
  let date=new Date();
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  return [year, month, day].map(formatNumber).join('-');
}

function formatSecondsFee(seconds,fee) {
  var second = seconds % 60;
  var minute = Math.floor(seconds / 60) % 60;
  var hour = Math.floor(seconds / 3600) % 60;
  if(minute>0 || second>0)
	{
       return (hour+1)*fee;
	}
	return hour*fee;
  //return [hour, minute, second].map(formatNumber).join(':')
}

function getbfee(hour,fee) {
   return hour*fee;
}

//数组长度
    const arradd= (arr,id)=>
    {
        if(arr.indexOf(id)<0)
        {
          arr.push(id)
        }
        return arr;
    }
    const arrdel= (arr,id)=>
    {
        if(arr.indexOf(id)>-1)
        {
         return arr.splice(arr.indexOf(id), 1);
        }
        return arr;
    }
//数组长度
    const arrsum= (arr,brr)=>
    {
    console.log(arr)
    const target = arr.filter((item,index) => brr.indexOf(item.id)>-1);
    console.log(target)
    let cc={"num":0,"fee":0};
    if(target)
    {
    target.forEach(function(item, index){
    cc.num+= parseInt(item.num)
    cc.fee+= parseFloat(item.fee)*parseInt(item.num)
       })
    //console.log(target.zt)
   }
    return cc;
  }
    const arrgetid= (target)=>
    {
    let cc=[]
    if(target)
    {
    target.forEach(function(item, index){
       cc.push(item.id)
       })
    console.log(target)
   }
    return cc;
  }
    module.exports = {
    formatTime: formatTime,
   
	getbhour:getbhour,
    arradd: arradd,
    arrsum: arrsum,
    arrgetid:arrgetid,
    getfee:getfee,
    getbtime:formatSecondsTime,
    gethour:gethour,
    getday:getday,
    arrdel: arrdel
}
