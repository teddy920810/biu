/**
 * “网站配置”相关接口
 */
import request from '@/utils/request'

export default {
  /**
   * 上传文件
   * @param data
   */
  upload(data) {
    return request({
      // headers: {'Content-Type': 'multipart/form-data' },
      url: '/file/upload',
      method: 'post',
      data
    })
  }
}

