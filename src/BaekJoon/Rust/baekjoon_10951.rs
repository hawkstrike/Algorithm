use std::io::{BufRead, stdin};

pub fn baekjoon_10951() {
    let mut result: String = String::new();
    let mut input: String = String::new();
    
    loop {
        stdin().read_line(&mut input).unwrap();
        
        if input.trim().is_empty() {
            break;
        }
        
        let mut iterator = input.split_whitespace();
        let a: i32 = iterator.next().unwrap().parse().unwrap();
        let b: i32 = iterator.next().unwrap().parse().unwrap();
        
        result.push_str(&(a + b).to_string());
        result.push_str("\n");
        input.clear();
    }
    
    println!("{}", result.trim());
}