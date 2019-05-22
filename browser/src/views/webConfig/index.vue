<template>
  <div class="app-container">
    <el-form ref="dataForm" :model="temp" label-width="80px">
      <el-form-item label="企业名称">
        <el-input v-model="temp.wname"></el-input>
      </el-form-item>
      <el-form-item label="企业电话">
        <el-input v-model="temp.tel"></el-input>
      </el-form-item>
      <el-form-item label="企业传真">
        <el-input v-model="temp.fax"></el-input>
      </el-form-item>
      <el-form-item label="企业邮箱">
        <el-input v-model="temp.email"></el-input>
      </el-form-item>
      <el-form-item label="IPC备案信息">
        <el-input v-model="temp.ipc"></el-input>
      </el-form-item>
      <el-form-item label="企业地址">
        <el-input v-model="temp.address"></el-input>
      </el-form-item>
      <el-form-item label="企业地址地图">
        <el-upload
          class="avatar-uploader"
          :data="{el:'addressUrl'}"
          :with-credentials="true"
          :action="uploadUrl"
          :headers="headers"
          :show-file-list="false"
          :on-success="handleAvatarSuccess1">
          <img v-if="temp.addressUrl" :src="temp.addressUrl" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
      </el-form-item>
      <el-form-item label="微信公众号二维码图片">
        <el-upload
          class="avatar-uploader"
          :data="{el:'wxQRCode'}"
          :with-credentials="true"
          :action="uploadUrl"
          :headers="headers"
          :show-file-list="false"
          :on-success="handleAvatarSuccess2">
          <img v-if="temp.wxQRCode" :src="temp.wxQRCode" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
      </el-form-item>
      <el-form-item label="手机网站二维码图片">
        <el-upload
          class="avatar-uploader"
          :with-credentials="true"
          action=""
          :data="{el:'wapQRCode'}"
          :http-request="uploadFile"
          :headers="headers"
          :show-file-list="false"
          :on-success="handleAvatarSuccess3">
          <img v-if="temp.wapQRCode" :src="temp.wapQRCode" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">保 存</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import webConfigApi from '@/api/webConfig'
import fileApi from '@/api/file'
import { getToken } from '@/utils/auth'
export default {
  data() {
    return {
      headers: { 'biu-token': getToken() },
      uploadUrl: process.env.FILE_UPLOAD_API,
      temp: {
        wid: undefined,
        wname: '',
        tel: '',
        fax: '',
        email: '',
        ipc: '',
        address: '',
        addressUrl: '',
        wxQRCode: '',
        wapQRCode: ''
      }
    }
  },
  created() {
    this.initData()
  },
  methods: {
    initData(){
      webConfigApi.findWebConfig('1130695754294988801').then(res => {
        this.temp = res.data.webConfig
      })
    },
    onSubmit() {
      console.log('submit!');
      this.$refs['dataForm'].validate((valid) => {
        if (!valid) return
        const tempData = Object.assign({}, this.temp)//copy obj
        webConfigApi.updateWebConfig(tempData).then(res => {
          tempData.updated = res.data.updated
          this.$message.success("更新成功")
        })
      })
    },
    handleAvatarSuccess1(res) {
      console.log(res)
      this.temp.addressUrl = process.env.BASE_API + res.url
    },
    handleAvatarSuccess2(res) {
      console.log(res)
      this.temp.wxQRCode = process.env.BASE_API + res.url
    },
    handleAvatarSuccess3(res) {
      console.log(res)
      this.temp.wapQRCode = process.env.BASE_API + res.url
    },
    uploadFile (params){
      console.log("uploadFile", params);
      const el = params.data.el

      const _file = params.file;
      const isLt2M = _file.size / 1024 / 1024 < 2;

      // 通过 FormData 对象上传文件
      const formData = new FormData();
      formData.append("file", _file);
      fileApi.upload(formData).then(res => {
        this.temp[el] = process.env.BASE_API + res.data.url
      })
    }
  }
}
</script>
<style rel="stylesheet/scss" lang="scss" scoped>
  .el-upload {
    display: inline-block;
    text-align: center;
    cursor: pointer;
    outline: 0;
    width: 100%!important;
  }
  .avatar-uploader {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader :hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 700px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 700px;
    height: 178px;
    display: block;
  }
</style>
