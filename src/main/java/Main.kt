package lumiProject

import twitter4j.TwitterFactory
import twitter4j.auth.AccessToken


fun main(args: Array<String>) {

    // twitter APIの設定 @LumiBot
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

    tweet = "テスト"

    //tweet実行
    twitter.updateStatus(tweet)
    println(tweet)
}
