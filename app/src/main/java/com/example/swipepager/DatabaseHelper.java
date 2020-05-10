package com.example.swipepager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "swipePager.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME_WORD = "word";
    private static final String COLUMN_NAME_ID = "id";
    private static final String COLUMN_NAME_NAME = "name";
    private static final String COLUMN_NAME_CONTENTS = "contents";
    private static final String COLUMN_NAME_JOB = "job";
    private static final String COLUMN_NAME_TAGS = "tags";


    private static final String TABLE_NAME_FAVORITE = "favorite";
    private static final String COLUMN_NAME_WORDID = "wordId";
    private static final String SQL_CREATE_ENTRIES_WORD = "CREATE TABLE " + TABLE_NAME_WORD + " ( " +
                                                        COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                                                        COLUMN_NAME_NAME + " TEXT, " +
                                                        COLUMN_NAME_CONTENTS + " TEXT, " +
                                                        COLUMN_NAME_JOB + " TEXT, " +
                                                        COLUMN_NAME_TAGS + " TEXT " +
                                                     " )";
    private static final String SQL_DELETE_ENTRIES_WORD = "DROP TABLE IF EXISTS " + TABLE_NAME_WORD;

    private static final String SQL_CREATE_ENTRIES_FAVORITE = "CREATE TABLE " + TABLE_NAME_FAVORITE + " ( " +
            COLUMN_NAME_ID + " INTEGER PRIMARY KEY autoincrement," +
            COLUMN_NAME_WORDID + " INTEGER "  +
            ")";
    private static final String SQL_DELETE_ENTRIES_FAVORITE = "DROP TABLE IF EXISTS " + TABLE_NAME_FAVORITE;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private void createTable(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES_WORD);
        db.execSQL(SQL_CREATE_ENTRIES_FAVORITE);
        InsertData(db);
    }

    private void InsertData(SQLiteDatabase db){
        db.execSQL("INSERT INTO " + TABLE_NAME_WORD + " VALUES('1','スティーブ・ジョブズ','ベストを尽くして失敗したら、ベストを尽くしたってことさ','アップル創業者','激励');");
        db.execSQL("INSERT INTO " + TABLE_NAME_WORD + " VALUES('2','秋元康','いつか、必ず、チャンスの順番が来ると信じなさい','プロデューサー','希望');");
        db.execSQL("INSERT INTO " + TABLE_NAME_WORD + " VALUES('3','落合博満','前向きにもがき苦しむ経験は、すぐに結果に結びつかなくても、必ず自分の生きる力になっていく','プロ野球監督','希望');");
        db.execSQL("INSERT INTO " + TABLE_NAME_WORD + " VALUES('4','糸井重里','「ゴールは遠いなぁ」と、がっかりするのも道のりです','コピーライター','激励');");
        db.execSQL("INSERT INTO " + TABLE_NAME_WORD + " VALUES('5','SLAM　DUNK','「負けたことがある」というのが　いつか　大きな財産になる','マンガ','激励');");
        db.execSQL("INSERT INTO " + TABLE_NAME_WORD + " VALUES('6','ドラえもん','きみはこれからも何度もつまづく。でもそのたびに立ち直る強さももってるんだよ','マンガ','激励');");
        db.execSQL("INSERT INTO " + TABLE_NAME_WORD + " VALUES('7','水谷豊','常に今日は明日の準備ですからね。今日やったことは必ず明日に返ってくるんです','俳優','希望');");
        db.execSQL("INSERT INTO " + TABLE_NAME_WORD + " VALUES('8','イチロー','小さいことを積み重ねるのが、とんでもないところへ行くただひとつの道だと思っています','プロ野球選手','希望');");
        db.execSQL("INSERT INTO " + TABLE_NAME_WORD + " VALUES('9','村上龍','モチベーションという概念は、希望につながっていなければならない','作家','希望');");
        db.execSQL("INSERT INTO " + TABLE_NAME_WORD + " VALUES('10','津田恒実','弱気は最大の敵','プロ野球選手','激励');");
        db.execSQL("INSERT INTO " + TABLE_NAME_WORD + " VALUES('11','池上彰','一度地獄を見ると、世の中につらい仕事はなくなるんです。苦しい経験を若いうちにするからこそ、得られるものもある','ジャーナリスト','激励');");
        db.execSQL("INSERT INTO " + TABLE_NAME_WORD + " VALUES('12','佐々木則夫','成功の反対は失敗ではなく「やらないこと」だ','サッカー指導者','勇気');");
        db.execSQL("INSERT INTO " + TABLE_NAME_WORD + " VALUES('13','マツコ・デラックス','自分が幸せかどうかは、自分で決めるしかないのよ','タレント','激励');");
        db.execSQL("INSERT INTO " + TABLE_NAME_WORD + " VALUES('14','スティーブ・ジョブズ','何かを捨てないと前に進めない','アップル創業者','勇気');");
        db.execSQL("INSERT INTO " + TABLE_NAME_WORD + " VALUES('15','笑福亭鶴瓶','家をきれいにする、約束を守る、お礼の手紙を書く、そういう基本をきっちり続けることが、自分の型の基本をつくってくれたと思っています','タレント','希望');");
        db.execSQL("INSERT INTO " + TABLE_NAME_WORD + " VALUES('16','SLAM　DUNK','あきらめたらそこで試合終了だよ','マンガ','希望');");
        db.execSQL("INSERT INTO " + TABLE_NAME_WORD + " VALUES('17','ドラえもん','いちばんいけないのはじぶんなんかだめだと思いこむことだよ','マンガ','激励');");
        db.execSQL("INSERT INTO " + TABLE_NAME_WORD + " VALUES('18','マルクス・アウレリウス','腋臭（わきが）の人間に君は腹を立てるのか。息がくさい人間に君は腹を立てるのか。その人間がどうしたらいいというのか。彼はそういう口を持っているのだ。また、そういう腋を持っているのだ。やむをえないことではないか。','ローマ皇帝','希望');");
        db.execSQL("INSERT INTO " + TABLE_NAME_WORD + " VALUES('19','徳川家康','怒りを敵と思え。','政治家','怒り')");
    }

    private String getInsertStr(int id, String name, String contents, String tags){
    StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" INSERT INTO " + TABLE_NAME_WORD);
        // stringBuilder.append("  ( ");
        // stringBuilder.append(COLUMN_NAME_ID + " ,");
        // stringBuilder.append(COLUMN_NAME_NAME + " ,");
        // stringBuilder.append(COLUMN_NAME_CONTENTS + " ,");
        // stringBuilder.append(COLUMN_NAME_TAGS);
        // stringBuilder.append(" ) ");
        stringBuilder.append(" VALUES ( ");
        stringBuilder.append(id + " ,");
        stringBuilder.append(" " +name + " ,");
        stringBuilder.append(contents + " ,");
        stringBuilder.append(tags);
        stringBuilder.append(" ) ; ");
        return stringBuilder.toString();
    }

    /**
     * This call needs to be made while the mCacheLock is held. The way to
     * ensure this is to get the lock any time a method is called ont the DatabaseHelper
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        createTable(db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int currentVersion) {
        // アップデートの判別
        db.execSQL(
                SQL_DELETE_ENTRIES_WORD
        );
        db.execSQL(
                SQL_DELETE_ENTRIES_FAVORITE
        );
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
