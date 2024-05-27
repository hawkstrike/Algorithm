use std::io::{BufRead, stdin};

pub fn baekjoon_1152() {
    let mut line: String = stdin().lock().lines().next().unwrap().unwrap().trim().to_string();
    let count: usize = line.split_whitespace().count();
    
    println!("{}", count);
}