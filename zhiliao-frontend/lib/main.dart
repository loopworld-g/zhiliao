import 'package:flutter/material.dart';
import 'package:http/http.dart' as http; // 用于发送HTTP请求

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: ChatPage(),
    );
  }
}

class ChatPage extends StatefulWidget {
  @override
  _ChatPageState createState() => _ChatPageState();
}

class _ChatPageState extends State<ChatPage> {
  final TextEditingController _controller = TextEditingController();
  final List<String> messages = [];

  void sendMessage() async {
    String text = _controller.text.trim();
    if (text.isEmpty) return;

    setState(() {
      messages.add("我: $text"); // 本地显示
    });
    _controller.clear();

    // 发送给后端
    try {
      var response = await http.post(
        Uri.parse("http://你的后端地址/api/send"),
        headers: {"Content-Type": "application/json"},
        body: '{"message": "$text"}',
      );

      if (response.statusCode == 200) {
        setState(() {
          messages.add("服务端: ${response.body}");
        });
      } else {
        setState(() {
          messages.add("服务端返回错误: ${response.statusCode}");
        });
      }
    } catch (e) {
      setState(() {
        messages.add("发送失败: $e");
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("聊天页面")),
      body: Column(
        children: [
          Expanded(
            child: ListView.builder(
              itemCount: messages.length,
              itemBuilder: (context, index) {
                return ListTile(
                  title: Text(messages[index]),
                );
              },
            ),
          ),
          Divider(height: 1),
          Padding(
            padding: const EdgeInsets.symmetric(horizontal: 8.0),
            child: Row(
              children: [
                Expanded(
                  child: TextField(
                    controller: _controller,
                    decoration: InputDecoration(
                      hintText: "输入消息...",
                    ),
                  ),
                ),
                IconButton(
                  icon: Icon(Icons.send),
                  onPressed: sendMessage,
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}
