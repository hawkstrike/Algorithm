use std::io::{BufRead, stdin};

pub fn baekjoon_10952() {
    let mut result: String = String::new();
    let mut input: String = String::new();
    
    loop {
        stdin().read_line(&mut input).unwrap();
        
        let mut iterator = input.split_whitespace();
        let a: i32 = iterator.next().unwrap().parse().unwrap();
        let b: i32 = iterator.next().unwrap().parse().unwrap();
        let sum: i32 = a + b;
        
        if sum == 0 {
            break;
        }
        
        result.push_str(&sum.to_string());
        result.push_str("\n");
        input.clear();
    }
    
    println!("{}", result.trim());
}