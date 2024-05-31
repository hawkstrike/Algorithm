use std::io::stdin;

pub fn baekjoon_1476() {
    let e_s_m: Vec<usize> = stdin().lines().next().unwrap().unwrap()
        .split_whitespace().map(|s| s.parse::<usize>().unwrap()).collect::<Vec<usize>>();
    let (e, s, m) = (e_s_m[0], e_s_m[1], e_s_m[2]);
    let (mut e1, mut s1, mut m1, mut count) = (1, 1, 1, 1);
    
    loop {
        if e == e1 && s == s1 && m == m1 {
            break;
        }
        
        e1 += 1;
        s1 += 1;
        m1 += 1;
        
        if e1 > 15 {
            e1 = 1;
        }
        
        if s1 > 28 {
            s1 = 1;
        }
        
        if m1 > 19 {
            m1 = 1;
        }
        
        count += 1;
    }
    
    println!("{}", count);
}