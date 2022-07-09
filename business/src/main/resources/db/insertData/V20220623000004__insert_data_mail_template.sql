
DELETE FROM mail_template;
INSERT INTO mail_template (mail_template_id, mail_template_div, title, text, created_at, updated_at) VALUES
(1, 1, '会員仮登録完了のお知らせ', '[[${dto.userName}]] 様\r\n\r\nご登録いただき、ありがとうございます。\r\n現在、仮登録の状態ですので、下記URLをクリックして登録を完了させてください。\r\n\r\nhttps://[[${dto.domain}]]/register/valified/[[${dto.onetimeKey}]]/\r\n\r\n', now(), now()),
(2, 1, '会員本登録完了のお知らせ', '[[${dto.userName}]] 様\r\n\r\nこの度はご登録いただき、ありがとうございます。\r\n[[${dto.userName}]]様の会員登録手続きが完了しました。\r\n\r\n------------------------------------------------------------------------\r\n会員専用ページへは、下記URLより、\r\nご登録いただいたメールアドレスとパスワードを入力してログインしてください。\r\n\r\nhttps://[[${dto.domain}]]/login/\r\n------------------------------------------------------------------------\r\n\r\n今後ともよろしくお願い致します。\r\n', now(), now()),
(3, 1, '新パスワード設定画面のお知らせ', '[[${dto.userName}]] 様\r\n\r\n新パスワード設定画面のURLをお知らせします。\r\n下記URLをクリックして、新しいパスワードを設定してください。\r\n\r\nhttps://[[${dto.domain}]]/register/remind/config/[[${dto.onetimeKey}]]/\r\n\r\n', now(), now()),
(4, 2, '商品の購入が完了しました。', '[[${dto.userName}]] 様\r\n\r\nこの度は、商品をご購入頂き、誠にありがとうございました。\r\n合計金額：[[${dto.amount}]] 円\r\n\r\n', now(), now());
