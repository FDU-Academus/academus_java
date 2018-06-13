Page({
  data: {
    category: [{ CATE:'咖啡',ID:'caffe'}, { CATE: '茶',ID:'tea' }, { CATE: '果汁',ID:'juice'}],
    detail: [{ ID: 'caffe', NAME: '拿铁', PRICE: 8.00, num: 0 }, { ID: 'caffe', NAME: '摩卡', PRICE: 8.00, num: 0 }, { ID: 2, NAME: '焦糖玛奇朵', PRICE: 8.00, num: 0 }, { ID: 'tea', NAME: '红茶', PRICE: 8.00, num: 0 }, { ID: 4, NAME: '绿茶', PRICE: 8.00, num: 0 }, { ID: 'juice', NAME: '果汁', PRICE: 8.00, num: 0 }, { ID: 'juice', NAME: '果汁', PRICE: 8.00, num: 0 }],
    totalprice:0,
    curIndex: 0,
    isScroll: true,
    toView: 'caffe',
    orderlist:[]
  },
  switchTab(e) {
    this.setData({
      toView: e.target.dataset.id,
      curIndex: e.target.dataset.index
    })
  },
  onLoad: function () {
    // this.getcate();
    // this.getdetail();  
},
// getcate:function(){
//   var that = this;
//   wx.request({
//     url: "http://127.0.0.1/academus/getcategory.action",//请求地址
//     header: {//请求头
//       "Content-Type": "applciation/json"
//     },
//     method: "GET",//get为默认方法/POST
//     success: function (res) {
//       console.log(res.data);//res.data相当于ajax里面的data,为后台返回的数据
//       that.setData({//如果在sucess直接写this就变成了wx.request()的this了.必须为getdata函数的this,不然无法重置调用函数
//         category: res.data.cate
//       })

//     }
//   })
// },
// getdetail:function(){
//   var that = this;
//   wx.request({
//     url: "http://127.0.0.1/academus/getmenucatedetail.action",//请求地址
//     header: {//请求头
//       "Content-Type": "applciation/json"
//     },
//     method: "GET",//get为默认方法/POST
//     success: function (res) {
//       console.log(res.data);//res.data相当于ajax里面的data,为后台返回的数据
//       that.setData({//如果在sucess直接写this就变成了wx.request()的this了.必须为getdata函数的this,不然无法重置调用函数
//         detail: res.data.mucd
//       })

//     }
//   })
// },
addCount(e) {
  const index = e.currentTarget.dataset.index;
  let detail = this.data.detail;
  let num = detail[index].num;
  num++;
  detail[index].num = num;
  this.setData({
    detail:detail
  });
  this.getTotalPrice();
},
minusCount(e) {
  const index = e.currentTarget.dataset.index;
  let detail = this.data.detail;
  let num = detail[index].num;
  if (num>0) num--;
  detail[index].num = num;
  this.setData({
    detail: detail
  });
  this.getTotalPrice();
},
getTotalPrice(){
  let detail = this.data.detail;
  let total = 0;
  for(let i=0; i<detail.length;i++){
    if(detail[i].num!=0){
      total += detail[i].num * detail[i].PRICE;
    }
  }
  this.setData({
    detail:detail,
    totalprice : total.toFixed(2)
  })

},
nextstep:function(){
  var that = this;
  let detail = that.data.detail;
  let orderlist = that.data.orderlist;
  for(let i=0;i<detail.length;i++){
    if(detail[i].num!=0){
      orderlist.push({NAME:detail[i].NAME,num:detail[i].num})
    }
    that.setData({
      orderlist:orderlist
    })
  }
  if (that.data.totalprice>0){
  wx.navigateTo({
    url: '../order/order?order='+ JSON.stringify(that.data.orderlist),
  })
  that.setData({
    orderlist:[]
  })
  }else{
    wx.showModal({
      title: '注意哦',
      content: '您还没点单呢！',
    })
  }
}
}
)