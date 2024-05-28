use std::io::{BufRead, stdin};

pub fn baekjoon_1181() {
    let mut n: usize = stdin().lines().next().unwrap().unwrap().trim().to_string().parse::<usize>().unwrap();
    let mut string_vector: Vec<String> = Vec::new();
    
    while n > 0 {
        n -= 1;
        
        let mut line: String = String::new();
        
        stdin().read_line(&mut line).unwrap();
        
        string_vector.push(line.trim().parse().unwrap());
    }
    
    string_vector.sort_by(|a, b| {
        if a.len() == b.len() {
            a.cmp(b)
        } else {
            a.len().cmp(&b.len())
        }
    });
    string_vector.dedup();
    
    println!("{}", string_vector.join("\n"));
}