package com.demo.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p> Title: Demo1 </p>
 * <p> Description: demo1 </p>
 *
 * @author xiaofanglei@126.com
 * @date 2020/02/18
 **/
@Service
@Slf4j
public class Demo1 {
    private static String orgPattern = "{i,like,sam,sung,samsung,mobile,ice,cream,man go}";

    private static List<String> splitWords = new ArrayList(Arrays.asList(
            orgPattern.replace("，", ",").replace("{","")
                    .replace("}","").split(",")));

    private static List<String> spiltWordsWithoutBlankSpace = new ArrayList(Arrays.asList(orgPattern.replace("，", ",").replace("{","")
            .replace("}","").replace(" ","").split(",")));

    /**
     * 直接拆分语句
     *
     * @param inputMsg
     */
    public void individualDictionaryWords(String inputMsg) {
        //判断单词是否存在
        wordExists(inputMsg, "");
    }

    /**
     * 根据输入拆分语句
     *
     * @param pattern
     * @param inputMsg
     */
    public void individualDictionaryWordsOnlyInput(String pattern, String inputMsg) {
        this.splitWords = new ArrayList(Arrays.asList(
                pattern.replace("，", ",").replace("{","")
                        .replace("}","").split(",")));
        this.spiltWordsWithoutBlankSpace = new ArrayList(Arrays.asList(pattern.replace("，", ",").replace("{","")
                .replace("}","").replace(" ","").split(",")));

        //判断单词是否存在
        wordExists(inputMsg, "");
    }

    /**
     * 递归判断之后的单词是否存在
     *
     * @param pattern
     * @param outWords
     */
    private void wordExists(String pattern,String outWords) {
        int leng = pattern.length();
        //判断单词是否存在
        for (int index = 1; index <= leng; index++) {
            String str = pattern.substring(0, index);
            //如果存在匹配的单词
            int size = this.spiltWordsWithoutBlankSpace.size();
            for (int i =0;i < size; i++){
                if(this.spiltWordsWithoutBlankSpace.get(i).replace(" ","").equals(str)){
                    if (index == leng) {
                        outWords += this.splitWords.get(i);
                        //输出一整句话
                        log.warn(outWords);
                        outWords = outWords.replace(this.splitWords.get(i),"");
                        continue;
                    }
                    //递归判断之后的单词是否存在
                    wordExists(pattern.substring(index, leng), outWords + str + " ");
                }
            }
        }
    }

}
