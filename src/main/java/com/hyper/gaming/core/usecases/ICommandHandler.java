package com.hyper.gaming.core.usecases;

public interface ICommandHandler<TCommand extends ICommand, TResult> {
    TResult execute(TCommand command);
}
