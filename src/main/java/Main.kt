package lumiProject

import okhttp3.OkHttpClient
import okhttp3.Request
import twitter4j.TwitterFactory
import twitter4j.auth.AccessToken
import java.net.CookieManager
import java.net.CookiePolicy

fun main(args: Array<String>) {

    // twitter APIの設定
    val consumerKey = "xxx"
    val consumerSecret = "xxx"
    val accessToken = "xxx"
    val accessTokenSecret = "xxx"

    // 初期化
    var tweet = ""

    // twitterインスタンスの生成
    val twitter = TwitterFactory().instance.apply {
        setOAuthConsumer(consumerKey, consumerSecret)
        oAuthAccessToken = AccessToken(accessToken, accessTokenSecret)
    }

    // クライアント作成
    val client = OkHttpClient()

    // クッキーの設定
    val cookieManager = CookieManager()
    cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL)

    val ua = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.99 Safari/537.36"

    val cookie = "xxx"

    // URLの指定
    val url = "https://vcard.ameba.jp/mypage"

    // 検索条件(正規表現)
    val regex = Regex(pattern = "level")

    // リクエスト作成
    val request= Request.Builder()
            .url(url)
            .header("User-Agent", ua)
            .addHeader("Cookie", cookie)
            .get()
            .build()

    // 実行
    val response = client.newCall(request).execute()

    // html取得
    val responseData = response.body?.string()

    // 一致するデータがなければ終了
    if(!regex.containsMatchIn(responseData.toString())) return

    // 正規表現の一致したところで切る
    val list = regex.split(responseData.toString())

    val level = list[3].substring(2, 5)

//    tweet = "Level : " + level

    tweet = "テスト"

    //tweet実行
    twitter.updateStatus(tweet)
    println(tweet)
}
