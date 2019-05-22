/**
 * “网站配置”相关接口
 */
import request from '@/utils/request'

export default {
  /**
   * 添加配置
   * @param data
   */
  addWebConfig(data) {
    return request({
      url: '/webConfig',
      method: 'post',
      data
    })
  },

  /**
   * 更新网站配置
   * @param data
   */
  updateWebConfig(data) {
    return request({
      url: '/webConfig',
      method: 'put',
      data
    })
  },
  /*updateWebConfig(data) {
    return request({
      url: '/file/upload',
      method: 'post',
      data
    })
  },*/

  /**
   * 查询网站配置
   * @param wid
   */
  findWebConfig(wid) {
    return request({
      url: '/webConfig/'+wid,
      method: 'get'
    })
  }

}

