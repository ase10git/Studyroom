// swiper
import Swiper from 'https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.mjs';

const swiper = new Swiper('.swiper', {
    direction: 'horizontal',

    loop: true,

    pagination: {
        el: '.swiper-pagination',
    ***REMOVED***,

    navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
    ***REMOVED***,

    autoplay: {
        delay: 3000,
    ***REMOVED***
***REMOVED***);