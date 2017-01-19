package ch06.ex10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import org.omg.CORBA.portable.InputStream;

public class UrlLinkLoader {
	public static String blockingReadPage(URL url) {
		InputStream in;
		StringBuilder sb = new StringBuilder();
		try {
			in = (InputStream) url.openStream();
			try {
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String s;
			try {
				while ((s = br.readLine()) != null) {
				sb.append(s);
				}
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			}
		} catch (IOException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		return sb.toString();
	}

	public static List<String> getLinks(String content) {
		List<String> list = new ArrayList<>();

		// TODO: リンクを取得する

        return list;
    }

	public static void main(String[] args) {
		try {
			URL url = new URL("https://ja.wikipedia.org/wiki/フィボナッチ数");
			CompletableFuture.supplyAsync(() -> blockingReadPage(url))
            .thenApply(UrlLinkLoader::getLinks)
            .thenAccept(x -> x.forEach(System.out::println));
    ForkJoinPool.commonPool().awaitQuiescence(10, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
    }
}
