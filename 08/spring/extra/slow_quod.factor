#! /usr/local/lib/factor/factor -script

USING: kernel strings sequences io splitting math math.parser 
math.ranges math.functions ;

IN: quodigious

: n-digit-nums ( n -- ns ) dup 1- [ 10 swap ^ ] bi@ swap (a,b) ;

: number>digits ( n -- digits ) number>string string>digits ;

: divisible? ( n1 n2 -- ? ) dup 0 = [ 2drop f ] [ mod 0 = ] if ;

: quod? ( n -- n ? )
    dup [ number>string CHAR: 1 swap member? not ]
        [ dup number>digits sum divisible? ]
        [ dup number>digits product divisible? ] tri and and ;

: print-if-quod ( n -- )
    quod? [ number>string print ] [ drop ] if ;

: print-quods ( -- )
    readln " " split [
        string>number n-digit-nums [ print-if-quod ] each nl
    ] each ;

print-quods ! cheating, as it relies on input being only 1 line
