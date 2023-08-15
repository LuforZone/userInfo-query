const axios = require('axios');

const baseUrl = 'http://localhost:8080/api/users'; // 修改为你的 Spring Boot 服务器地址

// 二十组用户数据
const userData = [
  {
    userName: 'User1',
    password: 'password1',
    email: 'user1@example.com',
    uuid: 'uuid1'
  },
  
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
