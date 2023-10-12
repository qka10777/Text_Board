import com.sun.management.DiagnosticCommandMBean;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Article> articles = new ArrayList<>();

    public static void main(String[] args) {

        int lastArticleId = 1;
        int lastCommentId = 1;

        while (true) {
            System.out.println("명령어 : ");
            String cmd = scan.nextLine();

            if (cmd.equals("exit")) {
                System.out.println("종료");
                break;

            } else if (cmd.equals("add")) {

                System.out.println("제목 : ");
                String title = scan.nextLine();
                System.out.println("내용 : ");
                String content = scan.nextLine();

                Article article = new Article(lastArticleId, title, content, getCurrentDate());
                articles.add(article);

                System.out.println("완료");
                lastArticleId++;

            } else if (cmd.equals("list")) {
                System.out.println("====================");
                for (int i = 0; i < articles.size(); i++) {
                    Article article = articles.get(i);

                    System.out.printf("번호 : %d \n", article.getId());
                    System.out.printf("제목 : %s \n", article.getTitle());
                    System.out.println("===================");
                }

            } else if (cmd.equals("update")) {
                System.out.println("번호 : ");
                int targetId = scan.nextInt();
                scan.nextLine();

                for (int i = 0; i < articles.size(); i++) {
                    Article article = articles.get(i);

                    if (targetId == article.getId()) {
                        System.out.print("제목 : ");
                        String newTitle = scan.nextLine();
                        System.out.print("내용 : ");
                        String newContent = scan.nextLine();

                        Article newArticle = new Article(targetId, newTitle, newContent, getCurrentDate());
                        articles.set(i, newArticle);
                        System.out.println("완료");
                    }
                }

            } else if (cmd.equals("delete")) {
                System.out.println("번호 : ");
                int targetId = scan.nextInt();
                scan.nextLine();

                for (int i = 0; i < articles.size(); i++) {
                    Article article = articles.get(i);
                    if (targetId == article.getId()) {
                        articles.remove(i);
                    }
                }

            } else if (cmd.equals("detail")) {
                System.out.println("번호 : ");
                int targetId = scan.nextInt();
                scan.nextLine();
                Article article = null;


                for (int i = 0; i < articles.size(); i++) {
                    article = articles.get(i);
                    if (targetId == article.getId()) {
                        article.increaseHit();

                        System.out.println("=======================");
                        System.out.printf("번호 : %d \n", article.getId());
                        System.out.printf("제목 : %s \n", article.getTitle());
                        System.out.printf("내용 : %s \n", article.getContent());
                        System.out.printf("조회수 : %d \n", article.getHit());
                        System.out.printf("날짜 : %s \n", article.getRegDate());
                        if (article.getComments() != null) {
                            System.out.println("-----------댓글------------");
                            System.out.printf("댓글 : %s \n", article.getComments());
                            System.out.println("=======================");
                        } else {
                            System.out.println("등록된 댓글이 없습니다.");
                        }


                        System.out.println("상세 메뉴 (1. 댓글 등록, 2. 추천, 3. 수정, 4. 삭제, 5. 목록으로) ");
                        int function = scan.nextInt();
                        if (function == 1) {
                            System.out.println("1. 댓글 등록");
                            scan.nextLine();
                            System.out.println("입력 : ");
                            String comments = scan.nextLine();
                            article.addComments(comments);
                            lastCommentId++;



                        }
                        if (function == 2) {
                            System.out.println("2. 추천");
                            scan.nextLine();
                        }
                        if (function == 3) {
                            System.out.println("3. 수정");
                            scan.nextLine();
                        }
                        if (function == 4) {
                            System.out.println("4. 삭제");
                            scan.nextLine();
                        }
                        if (function == 5) {
                            System.out.println("5. 목록");
                            scan.nextLine();
                        }
                    }
                }

            } else if (cmd.equals("search")) {
                System.out.println("검색 : ");
                String keyword = scan.nextLine();
                System.out.println("==================");
                for (int i = 0; i < articles.size(); i++) {
                    Article article = articles.get(i);
                    String title = article.getTitle();
                    String content = article.getContent();


                    if (title.contains(keyword) || content.contains(keyword)) {
                        System.out.printf("번호 : %d \n", article.getId());
                        System.out.printf("제목 : %s \n", article.getTitle());
                        System.out.printf("내용 : %s \n", article.getContent());
                        System.out.printf("날짜 : %s \n", article.getRegDate());
                    }
                }
            }


        }
    }

    public static String getCurrentDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        String formatedNow = now.format(formatter);

        return formatedNow;
    }


}