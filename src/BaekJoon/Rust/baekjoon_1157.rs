use std::io::{BufRead, stdin};
use std::str::Chars;

pub fn baekjoon_1157() {
    let line: String = stdin().lock().lines().next().unwrap().unwrap().to_uppercase();
    let mut line_chars: Chars = line.chars();
    let mut vector: Vec<i32> = vec![0; 26];
    
    for char in line_chars {
        vector[(char as u8 - 65) as usize] += 1;
    }
    
    let mut max: i32 = 0;
    let mut max_char: i32 = 0;
    
    for index in 0..vector.len() {
        if max < vector[index] {
            max = vector[index];
            max_char = (index + 65) as i32;
        } else if max == vector[index] {
            max_char = '?' as u8 as i32;
        }
    }
    
    println!("{}", max_char as u8 as char);
}