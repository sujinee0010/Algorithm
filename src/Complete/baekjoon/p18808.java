package Complete.baekjoon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class p18808 {
    static int note_book [][];
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int col = sc.nextInt();
        int row = sc.nextInt();
        note_book= new int[row][col];
        int st_cnt = sc.nextInt();
        ArrayList<int[][]> stickers = new ArrayList();

        for(int i=0;i<st_cnt;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int[][] sticker = new int[x][y];
            for(int xi=0;xi<x;xi++){
                for(int yi=0;yi<y;yi++){
                    sticker[xi][yi]=sc.nextInt();
                }
            }
            stickers.add(sticker);
        }

        Iterator it = stickers.iterator();
        while(it.hasNext()){
            // 스티커 1번
            int sticker [][]= (int[][]) it.next();
            System.out.println(">>STICKER");
            boolean isused = false;

            // 시작 좌표 , 배열 x, y
            isused = makeUseSticker(sticker,note_book,0,0,sticker.length,sticker[0].length);

            // 회전 시켜서
            if(!isused){
                //90
                isused = makeUseSticker(sticker, note_book, sticker.length-1, 0, sticker[0].length, sticker.length);
                //180
                if(!isused)
                    isused = makeUseSticker(sticker, note_book, sticker.length-1, sticker[0].length-1, sticker.length, sticker[0].length);
                //270
                if(!isused)
                    isused = makeUseSticker(sticker, note_book, 0, sticker[0].length-1, sticker[0].length, sticker.length);
            }
            System.out.println("노트북 상태 ");
            for(int i=0;i<note_book.length;i++){
                for(int j=0;j<note_book[i].length;j++){
                    System.out.print(note_book[i][j]);
                }
                System.out.println();
            }

        }
        int ans=0;
        // 세기
        for(int i=0;i<note_book.length;i++){
            for(int j=0;j<note_book[i].length;j++){
                if(note_book[i][j]==1)
                    ans++;

            }
        }
        System.out.println(ans);



    }

    private static boolean makeUseSticker(int[][] sticker, int[][] note_book, int start_i, int start_j , int s_row, int s_col ) {
        System.out.println(start_i+","+start_j);
        // 위 부터, 왼부터
        int nrow = note_book.length;
        int ncol = note_book[0].length;
        boolean isused = false;
        // 위부터 아래까지 탐색
        for(int j=start_j;j+s_col-1<ncol;j++){
            for(int i=start_i;i+s_row-1<nrow;i++) {

                int tmp[][] = note_book;
                boolean ispossible = true;

                // 스티커 대조 -> 하다가 안돼면
                for(int si=0;si<s_row;si++){
                    for(int sj=0;sj<s_col;sj++) {
                        if(sticker[si][sj]==1){
                            if(tmp[i+si][j+sj]==0){
                                tmp[i+si][j+sj]=1;
                            }
                            else{
                                // 안맞는 경우
                                ispossible = false;
                                break;
                            }
                        }
                    }
                    // 안맞는 경우 -> 그만
                    if(ispossible) break;
                }


                // 이번판 맞음 ?
                if(ispossible) {
                    note_book = tmp;
                    isused = true;
                }
            }
            if(isused)
                break;

        }

        return isused;

    }
}
