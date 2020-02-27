<?php

mb_internal_encoding("utf8");

session_start();

?>

<!DOCTYPE html>
<html lang="ja">
    
    <head>
        <title>マイページ登録</title>
        <link rel="stylesheet" type="text/css" href="mypage_hensyu.css">
    </head>
    <body>
        <header>
            <img src="4eachblog_logo.jpg">
            <div class="logout"><a href="log_out.php">ログアウト</a></div>
        </header>
        <main>
            <div class="box">
                <h2>会員情報</h2>
                <div class="hello">
                    <?php echo "こんにちは！　".$_SESSION['name']."さん";?>
                </div>
                <div class="pic">
                    <div class="profile_pic">
                        <img src="<?php echo $_SESSION['picture'];?>">
                    </div>
                </div>
                <form action="mypage_update.php" method="post">
                    <div class="basic_info">
                        <div class="name">
                            <label>氏名:</label><input type="text" value="<?php echo $_POST['name'];?>" size="40" name="name">
                            <br>
                        </div>
                        <div class="mail">
                            <label>メール:</label>
                            <input type="text" size="40" value="<?php echo $_POST['mail'];?>"pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" name="mail">
                            <br>
                        </div>
                        <div class="password">
                            <label>パスワード:</label>
                            <input type="password" class="formbox" size="40" value="<?php echo $_POST['password'];?>"pattern="^[a-zA-Z0-9]{6,}$" name="password" >
                            <br>
                        </div>
                    </div>
                    <div class="box3">
                        <div class="comments">
                            <input type="hidden"value="<?php echo $_POST['comments'];?>" name="comments">
                            <textarea rows="5" cols="110" name="comments"></textarea>
                        </div>
                    </div>
                    <div class="hensyubutton">
                        <input type="submit" class="submit_button" size="35" value="この内容に登録する">
                    </div>
                </form>
            </div>
        </main>
        
        <footer>
            ©2018 InterNous.inc.All rights reserved
        </footer>
    </body>
</html>                