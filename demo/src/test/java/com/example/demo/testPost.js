const axios = require('axios');

const baseUrl = 'http://localhost:8080/api/users'; // 修改为你的 Spring Boot 服务器地址

// 用户数据
//程序的作用为向本地程序抛出多组用户数据，测试接口是否能够正常接收
//有需要时可以引入随机数模块或通过拼接字符串的方式完成自动化测试
const userData = [
  {
    userName: 'User2',
    password: 'password2',
    email: 'user2@example.com',
    uuid: 'uuid2'
  },{
    userName: 'User3',
    password: 'password3',
    email: 'user3@example.com',
    uuid: 'uuid3'
  },
  {
    userName: 'User4',
    password: 'password4',
    email: 'user4@example.com',
    uuid: 'uuid4'
  }
  
];

// 使用 axios 发送 POST 请求来添加用户数据
async function addUsers() {
  for (const user of userData) {
    try {
      await axios.post(baseUrl, user);
      console.log(`User added: ${user.email}`);
    } catch (error) {
      console.error(`Error adding user ${user.email}: ${error.message}`);
    }
  }
}

addUsers();
