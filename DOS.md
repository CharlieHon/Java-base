# DOS命令

Dos：`Disk Operating System`磁盘操作系统

```dos
# 命令行输入指令

# Dos系统：1.接受指令 2.解析指令 3.执行指令

# window文件系统相应操作
```

- 相对路径，绝对路径

> 相对路径：从当前目录开始定位，形成的一个路径
>
> `..\..\abc2\test200\hello.txt`
>
> 绝对路径：从顶级目录/根目录开始定位，形成的路径
>
> `d:\abc2\test200\hello.txt`

- 常用的dos命令

1. 查看当前目录是什么内容

> `dir`
>
> `dir d:\abc2\test200`

2. 切换到其他盘下：盘符号 cd

> 切换到c盘	`cd /D c:`

3. 切换到当前盘的其他目录下

> `cd d:\abc2\test200`
>
> `cd ..\..\abc2\test200`

4. 切换到上一级

> `cd ..`

5. 切换到当前目录的根目录

> `cd \`

6. 查看指定的目录下所有的子级目录 `tree`
7. 清屏 `cls`
8. 退出DOS `exit`
9. 其他指令

```dos
# md 创建目录
> md test

# rd 删除目录
> rd test

# 创建文件，并输入内容
> echo Hello > Hello.txt

# 创建空文件
> type nul > abc.txt

# 删除文件
> del abc.txt

# 拷贝
> copy Hello.txt e:\javacode\test\Hello

# 剪切
move Hello.txt d:\tmp
```