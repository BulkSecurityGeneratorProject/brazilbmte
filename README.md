开发环境搭建 部署数据库

下载数据库文件，部署到本地，数据库名为brazilbmte,用户为root，密码为123456

后台环境

Java后台

指定目录新建一个文件夹，运行命令: git clone -b version0001_demo https://github.com/ZhuShuaibing/brazilbmte.git 代码下载完成之后，使用IDEA通过pom.xml打开java项目 然后启动Spring boot程序，则启动服务，在浏览器打开http://localhost:8080/api/users 验证服务是否启动成功；

管理后台

在上面目录下，运行命令：npm install,完成后运行:npm start,则自动启动http://localhost:9000/#/，显示管理后台，用户名密码为admin/admin和user/user

前台环境

git clone -b version001_demo https://github.com/ZhuShuaibing/brazilbmtefront.git 代码下载完成之后，运行命令：npm install,完成后运行:npm start,则自动启动http://localhost:8000/#/login 登陆界面，使用用户名和密码登陆。
