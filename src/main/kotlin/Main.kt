import java.lang.Integer.parseInt

fun main(args: Array<String>) {
    println("Hello World!")

    //https://qiita.com/k5n/items/cc0377b75d8537ef8a85
    //定数
    val a = 3

    //変数
    var b = 4
    b += 1

    //変数の型は中身から推論される(Pythonのように)
    //明示的に型を指定することが出来る
    //プリミティブ型は用意されておらずすべてクラスなので、大文字記述
    val c: Long = 5

    println(a + b + c)

    //数値定数
    val deg = 10
    val longInt = 334L //int型だがLong型を明示するときにLをつける
    val hex = 0x10
    val bin = 0b00000010
    val withE = 0.00314e3
    val flt = 3.14f //少数付きはデフォルトだとDouble型として扱う

    //文字
    val d = 'a' //一文字はシングルクォート(Char型)
    val e = '\uFF00'

    //文字列(String)はダブルクォート
    val f = "Hello World!\n"
    val g = """
       改行、インデントも全部含んでくれるってマ？ 
    """

    val h = "変数の値を計算するよ -> ${deg * 3} ドルマークは ${"$"}で表現する"

    //Pythonと同じように文字列そのものはイミュータブル（変更不可）で、
    // スライスのようにインデックスを指定し指定位置の文字を取得することもできる
    val three = h[14].toString() + h[15].toString()

    //暗黙の型変換
    val i: Long = 1 //OK Lを明示しなくとも入れることが出来る
    val j: Byte = 3
    /*
    val j: Float = 3.0 Doubleの値とみなされるためエラーとなる
    val j: Double = 3 Intの値とみなされるためエラーとなる
    val j: Int = j 8bitのByte型の値を32bitのInt型に入れようとしてもエラーになる
    */
    val k: Int = j.toInt() //Intに変換すると明示すればOK
    //toByte() toShort toInt toLong toFloat toDouble toChar

    val l = 5L + 2 //Long型にint型を入れることはでき、Longとintで計算もできる

    val str = "5.8"
    val cg = str.toDouble().toInt() //いきなりtoInt()するとNumberFormatExceptionが発生

    //1という値に対して左に2ビットシフトした値(0x00000004)とand演算する
    val m = (1 shl 2) and 0x000FF000 //shlはleftに2bitシフト
    val shift_left = 1.shl(2).and(0x000FF000) //mと結果は同じ

    val shift_right = 4.shr(2).or(0x00000002) //rightに2bitシフト
    val unregister_shift_right = -4.ushr(2).xor(0x000FFF00) //符号なし2bitシフト
    val reverse = shift_left.inv() //ビット反転

    //ぬるぽ対策Kotlinの仕様
    var n: String = "abc"
    // n = null nullをnullable型にしか入れられないのでエラーが起きる
    val o = n.length //nは絶対にnullではないため必ず実行できる

    var p: String? = "abc"
    p = null //型の最後に?をつけるとNullが可になる
    //val q = p.length pにnullがあり得るためコンパイルエラーが起きる
    //これを呼び出すためには、nullでないことをif文で確認してq.lengthを呼び出す必要がある
    val q = if(p != null) p.length else -1

    if (p != null && p.length > 0) //if文複合演算子で最初にnull出ないことを確認すれば、複合演算子でほかの条件を確認することもできる
        println("${p}") //nullではないことが明確なため呼び出してもコンパイルエラーが起きない

    val r = p?.length //ここで?を使うとnullでなければ実行、そうでないならnullを返す、という処理を行う
    //rはnullがあり得るので、Int?型として認識される

    //エルビス演算子
    val s = p?.length ?: -1 //nullでなければ数値を、nullなら-1を返す
    val ss = "134"
    val t = ss.toIntOrNull()?: 0 //sをInt型に変換するときにNullであれば、0を返すというエルビス演算子を使った書き方
    //toIntOrNull()は、Int型に変換するとともに、出来なかった場合nullを返す拡張関数(Stringクラスに対する関数）

    val u = "FFFF".toIntOrNull(16) //65535
    val v = "0xFFFF".toIntOrNull(16) //Null

    val w = 10000 //JVMのプリミティブint型として格納
    var x = w //同様
    println(w === x) //参照先を比較(結果はTrue)

    val boxedA: Int? = a //Boxing（プリミティブからラッパークラスへの自動変換）が行われる
    val anotherBoxedA: Int? = a //同様
    println(boxedA === anotherBoxedA) //それぞれ別の場所にBoxingして格納されているため、アドレスは異なる

    //配列
    val list = arrayOf(1, 2, 3) //[1, 2, 3]
    var arr: Array<Int?> = arrayOfNulls(3) //[null, null, null]
    val arr_length = arr.size //配列に対してlengthを使うとエラー(文字列に対してしか使えない) 結果は3
    val asc = Array(5) { i -> i * i } //
    asc.forEach { a -> print("${a},") }
    println()

    asc[0] = asc[1] + asc[2] //Arrayはミュータブルで変更可能
    //Boxingされないプリミティブ型の配列
    //ByteArray,ShortArray,IntArrayなど
    //専用関数を使って宣言する
    val y: IntArray = intArrayOf(1, 2, 3) //[1, 2, 3]

    //コレクション
    //KotlinのArray = Javaの配列
    // List,Map,Set等のデータの集合を扱うインタフェースがKotlin.collectionsパッケージにある。
    //これらはreadonlyで、中身を変更できるようにしたMutableList、MutableMap等が用意されている

    //https://qiita.com/opengl-8080/items/36351dca891b6d9c9687
    //後々追記

    //参照先のチェック a === b, c !== d
    //構造 a == b, c != d
    //nullを比較する場合に自動的に参照のチェックになる

    //制御文
    //if
    var max: Int
    val bb = 3
    if (a > bb) {
        max = a
    } else {
        max = bb
    }

    val maxVal = if (a > bb) a else bb //ワンライナー
    //複数行の場合、最後の値が変数に入る
    val max_if = if (a > bb) {
        print("max <- a(${a})")
        a
    } else {
        print("max <- bb(${bb})")
        bb
    }

    val xx = 3
    //when switch文の代替
    when (xx) {
        1 -> println("x = 1")
        3 -> println("x = 3")
        else -> {
            println("xx is not 1 or 3")
        }
    }

    val str_num = "5"
    val li = arrayOf(1, 5, 9)
    //whenの特殊な使用方法
    when (xx) {
        0, 1, 2 -> println("コンマ区切りで複数の値を指定")
        parseInt(str_num) -> println("関数から得た値との比較")
        in 7..10 -> println("範囲指定 7以上 10以下 (10を含む)")
        in li -> println("配列にその値が含まれるか")
        !in 0..100 -> println("値がその範囲に含まれない場合に実行")
        else -> println("類稀なこれらに含まれない値のようだ")
    }

    val str_prefix = "prefix sushi"
    //if同様、値を返すことが出来る
    val hasPrefix = when(str_prefix) {
        is String -> str_prefix.startsWith("prefix") //始まりがprefixであるならTrueを返す String型であるというチェック(is String)
        else -> false
    }

    fun Int.isOdd() = this % 2 != 0
    fun Int.isEven() = this % 2 == 0

    //引数を与えずにif文のように使用することも可能
    val aa = 3
    when {
        aa.isOdd() -> println("xx is odd")
        aa.isEven() -> println("xx is even")
        else -> println("xx is funny")
    }

    //for文
    for (i in 1..3) println(i) //1 2 3
    for (i in 1..3) {
        println(i)
    } //結果は同じ ブロックを使っても使わなくてもok

    val for_list = arrayOf(3, 1, 9, 5, 7)

    for (i in for_list) { //要素でループ
        print("${i},")
    }
    println()

    for (i in for_list.indices) { //インデックスでループ
        print("${for_list[i]},")
    }
    println()

    for((index, value) in for_list.withIndex()) //配列の要素と同時にインデックスも与える
        println("index -> ${index}, value -> $value")

    x = 10
    while (x > 0) x-- //while文(Java同様インクリメント演算子も使える)

    do {
        val y:Int? = null
    } while (y != null)

    //条件式での範囲指定
    x = 5
    if (x in 1..10) println("xは1以上10以下です")

    //down(逆順)とstep(i += 2のような1以外で加算されるループ)
    for (i in 1..4) print(i) //1234と出力
    println()
    for (i in 4 downTo 1) print(i) //4321と出力
    println()
    for (i in 1..10 step 2) print(i) //13579と出力
    println()
    for (i in 9 downTo 1 step 3) print(i) //963と出力
    println()


}