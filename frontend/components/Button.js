import $ from "jquery";

export class Button {
    constructor(label, onClick) {
        this.label = label;
        this.onClick = onClick
    }

    render() {
        return $('<button>')
            .text(this.label)
            .addClass('button')
            .on('click', this.onClick);
    }
}