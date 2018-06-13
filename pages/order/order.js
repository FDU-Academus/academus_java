// pages/order/order.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
  location:['赋比兴','形而上','暗物质','柳叶刀','结构洞','或与非'],
  index:0,
  orderlist:[],
  name:'',
  schoolid:0,

  },

  /**
   * 生命周期函数--监听页面加载
   */
  bindpickchange: function (e) {
    this.setData({
      index:e.detail.value
    })
  },

  postorder: function () {
    var that = this;
    wx.request({
      url: 'https://api.weixin.qq.com/sns/jscode2session',
      method: 'post',
      data: {
        user:that.data.name,
        userid:that.data.schoolid,
        order:that.data.orderlist,
      },
      header: { 'content-type': 'application/x-www-form-urlencoded' },
      success: function () {
        wx.showToast({
          title: '已下单',
          icon:'succes',
          duration:2000,
          mask:true
        })
      }
    })
  },

  onLoad: function(options){
    var that = this;
    var order = JSON.parse(options.order);
    that.setData({
      orderlist:null,
      orderlist:order
    })
    console.log(order)
  },


  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  }
})